package Payment;
import Components.CoinSlot;
import Components.NoteSlot;

public class CashProcessor implements PaymentProcessor {
    CoinSlot coinSlot;
    NoteSlot noteSlot;
    public CashProcessor(CoinSlot coinSlot, NoteSlot noteSlot){
        this.coinSlot = coinSlot;
        this.noteSlot = noteSlot;
    }
    @Override
    public boolean validate() {
        /* Find which  in which slot the money was inserted*/
        if(this.coinSlot.getAmount() != 0){
            Double amount = this.coinSlot.getAmount();
            if(Coin.validCoins.contains(amount)){
                return true;
            }
        }
        else if (this.noteSlot.getAmount() != 0){
            Double amount = this.noteSlot.getAmount();
            if(Note.validNotes.contains(amount)){
                return true;
            }
        }
        
        return false;

        }
    }
    

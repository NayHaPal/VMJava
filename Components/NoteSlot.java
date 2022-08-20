package Components;

import Payment.Cash;

public class NoteSlot implements CashSlot {
    Double amount;
    public NoteSlot(){
        this.amount = (double) 0;
    }
    @Override
    public void insert(Cash cash) {
        this.amount = cash.getAmount();
    }

    public Double getAmount(){
        return this.amount;
    }

    @Override
    public void resetAmount() {
        this.amount = (double) 0;
    }
    
}

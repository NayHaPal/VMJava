package States;
import Enumerations.MachineStatus;
import Exceptions.ItemNotAvailableException;
import Inventory.Item;
import Inventory.MoneyInventory;
import Machine.VendingMachine;
import Payment.Card;
import Payment.Cash;

public class InsertionState extends State {

    private VendingMachine vendingMachine;

    public InsertionState(VendingMachine vendingMachine) {
        this.currState = MachineStatus.InsertingMoney;
        this.vendingMachine = vendingMachine;
        System.out.println("[STATE CHANGE]: Insertion State");    
        this.vendingMachine.displayScreen.showMessage("Please insert coin, notes, or credit card.");
    }

    @Override
    public void insertCoin(Cash coin) {
        vendingMachine.coinSlot.insert(coin);
        /* Coin inserted is valid, update the current amount of money. */
        if(vendingMachine.cashProcess.validate()){
            vendingMachine.addInsertedMoney(vendingMachine.coinSlot.getAmount());
            vendingMachine.coinSlot.resetAmount();
            return;
        }
        vendingMachine.coinSlot.resetAmount();
        System.out.println("[DBG][Insertion Stage]: Invalid type of coin. Coin returned to user.");
    }

    @Override
    public void insertNote(Cash note) {
        vendingMachine.coinSlot.insert(note);
        /* Coin inserted is valid, update the current amount of money. */
        if(vendingMachine.cashProcess.validate()){
            vendingMachine.addInsertedMoney(vendingMachine.noteSlot.getAmount());
            vendingMachine.noteSlot.resetAmount();
            return;
        }
        System.out.println("[DBG][Insertion Stage]: Invalid type of note. Coin returned to user.");
    }

    @Override
    public void insertCard(Card c) {
        /* When a card is inserted we move the dispensing stage quickly. */
        /* Card has priority over coin. If there are already inserted coins it will dispense them*/
        vendingMachine.cardSlot.insertCard(c);
        if(vendingMachine.cardProcess.validate()){
            vendingMachine.moneyInventory.dispense(vendingMachine.getInsertedMoney());
            System.out.println("[DBG]: Card inserted is valid!");
        }
        else {
            System.out.println("[DBG]: Card inserted is invalid!");
            vendingMachine.machineState = new ReadyState(vendingMachine);
        }
    }

    @Override
    public void addItemToAisle(int row, int col, String name, String barcode, Double price){
        System.out.println("Cannot add items in insertion stage!");
    }

    @Override
    public void dispenseChange() {
        Double money = vendingMachine.getInsertedMoney();
        MoneyInventory moneyInventory = vendingMachine.moneyInventory;
        moneyInventory.dispense(money);
    }

    @Override
    public void dispenseItem(int row, int col) {
        System.out.println("Cannot dispense in insertion stage!");
    }

    @Override
    public void useKeyPad(char c) {
        
    }

    @Override
    public void pressEnter() {
        if(hasEnoughCashOrCredit()){
            vendingMachine.machineState = new DispensingState(vendingMachine);
            vendingMachine.machineState.dispenseChange();
        }
        vendingMachine.displayScreen.showMessage("Insufficient funds please more cash/use a different card.");
    }

    private Boolean hasEnoughCashOrCredit(){
        Double insertedMoney = vendingMachine.getInsertedMoney();
        Item item = vendingMachine.itemInventory.getItem(vendingMachine.selectedItemRow, vendingMachine.selectedItemCol);
        if(item == null){
            vendingMachine.moneyInventory.dispense(insertedMoney);
            String msg = "Item is not available!";
            vendingMachine.displayScreen.showMessage(msg);
            throw new ItemNotAvailableException(msg);
        }
        Double itemPrice = item.getPrice();

        System.out.println("[DBG][Insertion state]: Item Price is: " + itemPrice);
        System.out.println("[DBG][Insertion state]: Inserted Money is: " + insertedMoney);

        if(vendingMachine.cardSlot.getCard() != null && !vendingMachine.cardProcess.hasEnoughCredit(itemPrice)){
            System.out.println(vendingMachine.cardProcess.hasEnoughCredit(itemPrice));
            String msg = "Insufficient funds, please insert more coins/notes.";
            vendingMachine.displayScreen.showMessage(msg);
            return false;
        } else if (vendingMachine.cardSlot.getCard() == null && itemPrice > insertedMoney){
            return false;
        }

        if(vendingMachine.cardSlot.getCard() != null){
            System.out.println("[DBG] [Insertion state]: Card is being used!");
            vendingMachine.cardProcess.processPayment(itemPrice);
        }

        return true;
    }
}

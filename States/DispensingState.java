package States;

import Enumerations.MachineStatus;
import Exceptions.ItemNotAvailableException;
import Exceptions.insufficientChangeException;
import Inventory.Item;
import Machine.VendingMachine;
import Payment.Card;
import Payment.Cash;

public class DispensingState extends State {

    private VendingMachine vendingMachine;

    public DispensingState(VendingMachine vendingMachine) {
        this.currState = MachineStatus.dispensingMoneyAndItem;
        this.vendingMachine = vendingMachine;        
        System.out.println("[STATE CHANGE]: Dispensing Change And Item");    
    }

    @Override
    public void insertCoin(Cash coin) {
        System.out.println("[DBG][Dispensing Stage]: Cannot insert coin in this stage.");

    }

    @Override
    public void insertNote(Cash note) {
        System.out.println("[DBG][Dispensing Stage]: Cannot insert note in this stage.");
    }

    @Override
    public void insertCard(Card card) {
        System.out.println("[DBG][Dispensing Stage]: Cannot insert card in this stage.");
    }

    @Override
    public void addItemToAisle(int row, int col, String name, String barcode, Double price) {
        System.out.println("[DBG][Dispensing Stage]: Cannot insert item in this stage.");

    }

    @Override
    public void dispenseChange() {
        Double insertedMoney = vendingMachine.getInsertedMoney();
        Item item = vendingMachine.itemInventory.getItem(vendingMachine.selectedItemRow, vendingMachine.selectedItemCol);
        Double itemPrice = item.getPrice();
        Double neededChange = vendingMachine.cardSlot.getCard() != null ? 0 : insertedMoney - itemPrice;
        System.out.println("[DBG]: neededChange = " + neededChange);
        if(neededChange > 0 && !vendingMachine.moneyInventory.dispense(neededChange)){
            String msg = "Machine has no enough change!";
            vendingMachine.displayScreen.showMessage(msg);
            vendingMachine.machineState = new ReadyState(vendingMachine);
            throw new insufficientChangeException(msg);
        }
        dispenseItem(vendingMachine.selectedItemRow, vendingMachine.selectedItemCol);
        vendingMachine.machineState = new ReadyState(vendingMachine);
        
    }

    @Override
    public void dispenseItem(int row, int col) {
        Item item = vendingMachine.itemInventory.removeIteAtPosition(vendingMachine.selectedItemRow, vendingMachine.selectedItemCol);
        if(item == null){
            String msg = "Item is not available";
            throw new ItemNotAvailableException(msg);
        }

        System.out.println("[DBG][Dispensing Stage]: Item with Barcode: " + item.getBarcode() + " was dispensed!");
    }

    @Override
    public void useKeyPad(char c) {
        System.out.println("[DBG][Dispensing Stage]: Cannot use keypad in this stage.");
    }

    @Override
    public void pressEnter() {
        System.out.println("[DBG][Dispensing Stage]: Pressing enter has no effect in this stage");
        
    }


    
}

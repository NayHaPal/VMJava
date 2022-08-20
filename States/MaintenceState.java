package States;

import Enumerations.MachineStatus;
import Machine.VendingMachine;
import Payment.Card;
import Payment.Cash;

public class MaintenceState extends State{

    private VendingMachine vendingMachine;

    public MaintenceState(VendingMachine vendingMachine) {
        System.out.println("[DBG][STATE CHANGE]: Machine is in Maintence State");
        this.currState = MachineStatus.Ready;
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin(Cash coin) {
        System.out.println("Can't insert money in Maintenance state");
    }

    @Override
    public void insertNote(Cash note) {
        System.out.println("Can't insert money in Maintenance state");
    }

    @Override
    public void insertCard(Card card) {
        System.out.println("Can't insert card in Maintenance state");
    }

    @Override
    public void addItemToAisle(int row, int col, String name, String barcode, Double price) {
        vendingMachine.itemInventory.addItemAtPosition(row, col, name, barcode, price);
    }

    @Override
    public void dispenseChange() {
        System.out.println("Can't dispense change in Maintenance state");
    }

    @Override
    public void dispenseItem(int row, int col) {
        System.out.println("Can't dispense Item  in Maintenance state");
    }

    @Override
    public void useKeyPad(char c) {   
        System.out.println("Can't use keypad in this state");
     
    }

    @Override
    public void pressEnter() {
        System.out.println("Can't use keypad in this state");
        
    }


    
}

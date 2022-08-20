package States;
import Enumerations.MachineStatus;
import Exceptions.InvalidSelectionException;
import Machine.VendingMachine;
import Payment.Card;
import Payment.Cash;

public class ReadyState extends State {
    VendingMachine vendingMachine;

    public ReadyState(VendingMachine vendingMachine) {
        this.currState = MachineStatus.Ready;
        this.vendingMachine = vendingMachine;
        /* Make sure no money, no card, and no selections are preset. */
        this.vendingMachine.cardSlot.removeCard();
        vendingMachine.resetInsertedMoney();
        this.vendingMachine.resetSelection();

        System.out.println("[STATE CHANGE]: Ready");
    }

    @Override
    public void insertCoin(Cash coin) {
        System.out.println("Select Item before Inserting Money");
    }

    @Override
    public void insertNote(Cash note) {
        System.out.println("Select Item before Inserting Money");
    }

    @Override
    public void insertCard(Card card) {
        System.out.println("Can not insert card in ready state");
    }

    @Override
    public void addItemToAisle(int row, int col, String name, String barcode, Double price){
        System.out.println("Machine has to be in Maintenance State to Add Items.");
    }

    @Override
    public void dispenseChange() {
        System.out.println("Can't dispense in ready state!");
    }

    @Override
    public void dispenseItem(int row, int col) {
        System.out.println("Can't dispense in ready state!");
    }

    @Override
    public String toString() {
        return "ReadyState";
    }

    @Override
    public void useKeyPad(char c) {
        /* Valid entries are combinations of two digits other than that its regarded as invalidInput */
        /* Once a character is recieved that is not a digit, machine will move to the next state, which is coin/money/credit card insertion */
        String currentEntry = vendingMachine.keyPad.keyPush(c);
        vendingMachine.displayScreen.showMessage("Key pushed! Current selection is: " + currentEntry);
    }

    @Override
    public void pressEnter() {
        String input = vendingMachine.keyPad.getInput(); 
        if(vendingMachine.itemInventory.isValidSelection(input)){
            vendingMachine.setSelection(input);
            vendingMachine.machineState = new InsertionState(vendingMachine);
            return;
        }
        vendingMachine.keyPad.pushReset();
        throw new InvalidSelectionException("Selection combination of " + input + " is invalid, please retry.");
    }

}

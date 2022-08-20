package Tests;
import Machine.VendingMachine;
import Payment.Coin;
import States.ReadyState;

/* Responsible */
public class Test1 {
    public static void main(String[] args) {
        int rows = 2;
        int cols = 2;
        int depth = 2;
        /* Machine starts with Maintenance State */
        VendingMachine candyMachine = new VendingMachine(rows, cols, depth);

        /* TEST1: User will select an item, that is not available.
         * There is no change in the machine
         * Expected behaviour: Change should be returned, message will appear on display. */
        /* Set the machine to be in ready state, it has no change, and has no items. */
        candyMachine.machineState = new ReadyState(candyMachine);
        /* Selecting item at the second row, and third column */
        candyMachine.machineState.useKeyPad('0');
        candyMachine.machineState.useKeyPad('0');
        /* This method will move the state of the machine to Insertion stage */
        candyMachine.machineState.pressEnter();
        candyMachine.machineState.insertCoin(new Coin(25));
        candyMachine.machineState.insertCoin(new Coin(25));
        candyMachine.machineState.insertCoin(new Coin(50));
        candyMachine.machineState.insertCoin(new Coin(100));
        candyMachine.machineState.insertCoin(new Coin(10));
        candyMachine.machineState.pressEnter();
        assert candyMachine.moneyInventory.getTotal() == 0.0;
    }
}

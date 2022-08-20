package Tests;
import Machine.VendingMachine;
import Payment.Coin;
import States.ReadyState;

/* Responsible */
public class Test2 {
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

        /* Refill the inventory */

        /* Filling up inventory */
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                for(int d = 0; d < depth; d++){
                    String name = "ITEM " + r + ", " + c + ", " + ", " + d;
                    String barcode = "C" + r + c + d;
                    Double price = (double) 2;
                    candyMachine.machineState.addItemToAisle(r, c, name, barcode, price);
                }
            }
        }
        /* Machine is now ready to be used */
    
        candyMachine.machineState = new ReadyState(candyMachine);

        /* Test 2, keep selecting the same cell at col: 1, col: 1. Empty it, see what happens when we try to get the third item. */

        candyMachine.machineState.useKeyPad('1');
        candyMachine.machineState.useKeyPad('1');
        candyMachine.machineState.pressEnter();

        candyMachine.machineState.insertCoin(new Coin(100));
        candyMachine.machineState.insertCoin(new Coin(100));
        candyMachine.machineState.pressEnter();
        
        /* Again.. */

        candyMachine.machineState.useKeyPad('1');
        candyMachine.machineState.useKeyPad('1');
        candyMachine.machineState.pressEnter();
        candyMachine.machineState.insertCoin(new Coin(100));
        candyMachine.machineState.insertCoin(new Coin(100));
        candyMachine.machineState.insertCoin(new Coin(100));
        candyMachine.machineState.insertCoin(new Coin(25));
        candyMachine.machineState.insertCoin(new Coin(50));
        candyMachine.machineState.insertCoin(new Coin(25));
        candyMachine.machineState.insertCoin(new Coin(25));
        candyMachine.machineState.pressEnter();

        /* Again.. item should be unavailable. */
        candyMachine.machineState.useKeyPad('1');
        candyMachine.machineState.useKeyPad('1');
        candyMachine.machineState.pressEnter();
        candyMachine.machineState.insertCoin(new Coin(100));
        candyMachine.machineState.insertCoin(new Coin(100));
        candyMachine.machineState.insertCoin(new Coin(100));
        candyMachine.machineState.insertCoin(new Coin(25));
        candyMachine.machineState.insertCoin(new Coin(50));
        candyMachine.machineState.insertCoin(new Coin(25));
        candyMachine.machineState.insertCoin(new Coin(25));
    
        candyMachine.machineState.pressEnter();

        /* Two coins should be returned to user. An exception shall raise. */
        
    }
}


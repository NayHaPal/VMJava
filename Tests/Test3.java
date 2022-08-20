package Tests;
import Machine.VendingMachine;
import Payment.Card;
import States.ReadyState;

public class Test3 {
    public static void main(String[] args) {
        int rows = 2;
        int cols = 2;
        int depth = 2;
        /* Machine starts with Maintenance State */
        VendingMachine candyMachine = new VendingMachine(rows, cols, depth);

        /* TEST3: Use card for payment.
         * There is no change in the machine
         * Expected behaviour: Card has enough amount, item should be dispensed accordingly. */

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
        Card card = new Card("12", "2022", "Nayef Hawa",  100000.0);
        candyMachine.machineState.insertCard(card);
        candyMachine.machineState.pressEnter();
        /* Two coins should be returned to user. An exception shall raise. */
        
    }
}


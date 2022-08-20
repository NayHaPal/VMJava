package States;
import Enumerations.MachineStatus;
import Payment.Card;
import Payment.Cash;
/**
 * State
 */
public abstract class State {
    MachineStatus currState;
    abstract public void insertCoin(Cash coin);
    abstract public void insertNote(Cash note);
    abstract public void insertCard(Card card);
    abstract public void addItemToAisle(int row, int col, String name, String barcode, Double price);
    abstract public void dispenseChange();
    abstract public void dispenseItem(int row, int col);
    abstract public void useKeyPad(char c);
    abstract public void pressEnter();
}
package Components;
import Payment.Cash;

public interface CashSlot {
    public void insert(Cash cash);
    public void resetAmount();
}

package Machine;
import Components.CardSlot;
import Components.CoinSlot;
import Components.Display;
import Components.KeyPad;
import Components.NoteSlot;
import Inventory.ItemsInventory;
import Inventory.MoneyInventory;
import Payment.CardProcessor;
import Payment.CashProcessor;
import States.MaintenceState;
import States.State;

public class VendingMachine {
    public State machineState;
    public CardSlot cardSlot;
    public CoinSlot coinSlot;
    public NoteSlot noteSlot;
    public KeyPad keyPad;
    public Display displayScreen;
    public MoneyInventory moneyInventory;
    public ItemsInventory itemInventory;
    public CashProcessor cashProcess;
    private String selection;
    public CardProcessor cardProcess;
    private Double insertedMoney;
    public int selectedItemRow = -1;
    public int selectedItemCol = -1;

    public VendingMachine(int rows, int cols, int depth){
        machineState = new MaintenceState(this);
        this.cardSlot = new CardSlot();
        this.coinSlot = new CoinSlot();
        this.noteSlot = new NoteSlot();
        this.keyPad = new KeyPad();
        this.displayScreen = new Display();
        this.moneyInventory = new MoneyInventory(5);
        this.itemInventory = new ItemsInventory(rows, cols, depth);
        this.cashProcess = new CashProcessor(this.coinSlot, this.noteSlot);
        this.cardProcess = new CardProcessor(this.cardSlot);
        insertedMoney = (double) 0;
    }

    public String getSelection() {
        return selection;
    }

    public void setSelection(String selection) {
        selectedItemRow = Character.getNumericValue(selection.charAt(0));
        selectedItemCol = Character.getNumericValue(selection.charAt(1));
        this.selection = selection;
    }

    public void resetSelection() {
        selectedItemRow = -1;
        selectedItemCol = -1;
        this.selection = "";
    }

    public Double getInsertedMoney() {
        return this.insertedMoney;
    }

    public void resetInsertedMoney() {
        this.insertedMoney = (double) 0;
    }

    public void addInsertedMoney(Double insertedMoney) {
        this.moneyInventory.addMoney(insertedMoney);
        this.insertedMoney += insertedMoney;
    }

}

package Payment;
import java.util.HashSet;
import java.util.Set;

public class Note extends Cash{
    public static  Set<Double> validNotes = new HashSet<>();

    static{
        validNotes.add((double) 20);
        validNotes.add((double) 50);
    }
    
    public Note(double amount){
        this.amount = amount;
    }

    @Override
    public double getAmount() {
        return amount;
    }
    
}

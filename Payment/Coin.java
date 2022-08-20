package Payment;

import java.util.HashSet;
import java.util.Set;

public class Coin extends Cash {
        public static Set<Double> validCoins = new HashSet<>();
        static {
        validCoins.add((double) 0.1);
        validCoins.add((double) 0.25);
        validCoins.add((double) 0.5);
        validCoins.add((double) 1);
        }

    public Coin(double amount){
        this.amount = amount * 0.01;
    }
    
    @Override
    public double getAmount() {
        return amount;
    }
    
}

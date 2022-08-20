package Inventory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import Payment.Coin;
import Payment.Note;

public class MoneyInventory {
    public SortedMap<Double, Integer> moneyCount; // this should hold the count of elements of denominations 0.1, 0.25, 0.5, 1, 20, and 50 only.
    private Double total = (double) 0;
    public MoneyInventory(int N){
        moneyCount = new TreeMap<>();
        
        for(Double amount: Note.validNotes){
            moneyCount.put(amount, N);
            total += amount * N;
        }
        for(Double amount: Coin.validCoins){
            moneyCount.put(amount, N);
            total += amount * N;
        }
        System.out.println("[DBG]: Machine has been initialized with " + total + " of money!");
    }

    public Double getTotal() {
        return total;
    }
    public void setTotal(Double total) {
        this.total = total;
    }
    
    public void addMoney(Double amount){
        total += amount;
        moneyCount.put(amount, moneyCount.getOrDefault(amount, 0) + 1);
    }

    public boolean dispense(double amount){
        if(amount == 0) return true;
        List<Double> availableChange = new ArrayList<Double>();
        List<Double> change  = new ArrayList<Double>();        
        Double runningAmount = (double) 0;
        for(Double money : moneyCount.keySet()){
            if(moneyCount.getOrDefault(money, 0) != 0)
              availableChange.add(money);
        }

        Collections.sort(availableChange, Collections.reverseOrder());
        System.out.println(availableChange);

        int idx = 0; /* This will point to the coins/money with highest value */
        /* helper function to determine the needed coins to be dispensed. */
        Boolean Result = hepler(availableChange, amount, runningAmount, change, idx);
        return Result;
    }

    private boolean hepler(List<Double> availableChange, double amount, double runningAmount, List<Double> result, int idx) {
        if(runningAmount == amount){
            System.out.println("[DBG]: Machine has enough change");
            System.out.println("[DBG]: Change for user is as follows:");
            System.out.println(result);
            /* When change is successful, reduce the change from the total amount. */
            this.total -= runningAmount;
            return true;
        }
        if(idx >= availableChange.size()) return false;
        if(runningAmount + availableChange.get(idx) > amount){
            return hepler(availableChange, amount, runningAmount, result, idx+1);
        }
        Double currChange = availableChange.get(idx);
        Integer countOfChange = this.moneyCount.getOrDefault(currChange, 0);
        if(countOfChange > 0){
            this.moneyCount.put(currChange, countOfChange - 1);
            runningAmount += currChange;
            if(result.size() - 1 < 0) result.add(currChange);
            else result.add(result.size() - 1, currChange);
            if(hepler(availableChange, amount, runningAmount, result, idx)) return true;
            result.remove(result.size() - 1);
            runningAmount -= currChange;
            countOfChange = this.moneyCount.put(currChange, this.moneyCount.getOrDefault(currChange, 0) + 1);
            this.moneyCount.put(currChange, countOfChange + 1);

        }
        return hepler(availableChange, amount, runningAmount, result, idx+1);
    }

}

package Payment;

import java.util.HashMap;

import Components.CardSlot;

public class CardProcessor implements PaymentProcessor{
    /* To model acceptable cards numbers */
    HashMap<String, Boolean> acceptableCards;
    CardSlot cardSlot;
    public CardProcessor(CardSlot cardSlot) {
        acceptableCards = new HashMap<String, Boolean>();
        /* To model acceptable cards */
        acceptableCards.getOrDefault("123", true);
        acceptableCards.getOrDefault("124", true);
        this.cardSlot = cardSlot;
    }
    @Override
    public boolean validate() {
        /* All cards are valid. */
         return true;
    }

    public boolean hasEnoughCredit(double amount){
        Card currentCardUsed = cardSlot.getCard();
        return currentCardUsed != null && amount < currentCardUsed.getBalance();
    }

    public boolean processPayment(double amount){
        Card currentCardUsed = cardSlot.getCard();
        if(currentCardUsed == null) return false;
        currentCardUsed.deductBalance(amount);
        return true;
    }
    
}
 
package Components;

import Payment.Card;

/* This object models reading a card */
public class CardSlot{
    public Card currentCard;
    
    /* This method does not make sense, but will use it to model a real card. */
    public void insertCard(Card card){
         this.currentCard = card;
    }

    public void removeCard(){
        currentCard = null;
    }

    public String getId(){
        if(currentCard == null) return "";
        return currentCard.getId();
    }

    public Double getBalance(){
        return currentCard.getBalance();
    }

    public Card getCard(){
        return this.currentCard;
    }
}

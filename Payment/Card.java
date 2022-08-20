package Payment;

public class Card {
    private String id, validDate, owner;
    private Double balance;

    public Card (String id, String validDate, String owner, Double balance){
        this.id = id;
        this.owner = owner;
        this.validDate = validDate;
        this.balance = balance;
    }

    public Double getBalance() {
        return balance;
    }

    public void deductBalance(Double balance) {
        this.balance -= balance;
    }

    public String getOwner() {
        return owner;
    }
    public String getValidDate() {
        return validDate;
    }
    public String getId() {
        return id;
    }


}

package Components;

import Payment.Cash;
import Payment.Coin;

public class CoinSlot implements CashSlot {
    private Coin coin;

    public Double getAmount() {
        return this.coin.getAmount();
    }

    @Override
    public void insert(Cash coin) {
        this.coin = (Coin) coin;
    }

    @Override
    public void resetAmount() {
        this.coin = null;
    }

}

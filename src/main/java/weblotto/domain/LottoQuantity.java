package weblotto.domain;

import weblotto.Constant;

public class LottoQuantity {

    private final int lottoQuantity;

    public LottoQuantity(int lottoQuantity) {
        this.lottoQuantity = lottoQuantity;
    }

    private void isBuyAmountValid(int buyAmount) {
        if (buyAmount < Constant.MIN_BUY_AMOUNT) {
            throw new IllegalArgumentException(Constant.BUY_AMOUNT_ERROR);
        }
    }

    private int amountToQuantity(int buyAmount) {
        isBuyAmountValid(buyAmount);
        return buyAmount / Constant.MIN_BUY_AMOUNT;
    }

    public int lottoQuantity() {
        return this.lottoQuantity;
    }
}

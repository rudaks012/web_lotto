package weblotto.domain;

import weblotto.Constant;
import weblotto.strategy.Numbers;

import java.util.List;

public class LottoYield {
    private static final String STRING_PROFIT = "이익";
    private static final String STRING_LOSS = "손해";
    private static final int DEFAULT_LOTTO_YIELD = 1;

    private final double yield;

    public LottoYield(double yield) {
        this.yield = yield;
    }

    public LottoYield(List<LottoTicket> lottoTickets, Numbers winnerNumber) {
        this.yield = operationYield(lottoTickets, winnerNumber);
    }

    private double operationYield(List<LottoTicket> lottoTickets, Numbers winnerNumber) {
        double lottoPrize = lottoTickets.stream()
                .mapToDouble(ticket -> ticket.rank(winnerNumber).prize)
                .sum();

        double buyAmount = lottoTickets.size() * Constant.MIN_BUY_AMOUNT;

        return lottoPrize / buyAmount;
    }

    public double yield() {
        return yield;
    }

    public String stringYield() {
        if (yield >= DEFAULT_LOTTO_YIELD) {
            return STRING_PROFIT;
        }
        return STRING_LOSS;
    }

    public boolean checkYield(double yield) {
        return this.yield == yield;
    }
}

package weblotto;

import weblotto.strategy.Auto;
import weblotto.strategy.Numbers;

public class LottoTicket {

    private final Numbers lottoNumbers;

    public LottoTicket(Numbers lottoNumbers) {
        this.lottoNumbers = new Auto();
    }
}

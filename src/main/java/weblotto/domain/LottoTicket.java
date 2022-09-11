package weblotto.domain;

import weblotto.strategy.Auto;
import weblotto.strategy.Manual;
import weblotto.strategy.Numbers;

import java.util.Collections;
import java.util.List;

public class LottoTicket {

    private final Numbers lottoNumbers;

    public LottoTicket() {
        this.lottoNumbers = new Auto();
    }

    public LottoTicket(String stringNumber) {
        this.lottoNumbers = new Manual(stringNumber);
    }

    public LottoTicket(List<Integer> lottoNumbers) {
        this.lottoNumbers = new Auto(lottoNumbers);
    }

    public List<Integer> lottoNumber() {
        return Collections.unmodifiableList(lottoNumbers.readOnlyNumbers());
    }

    public LottoRank rank(Numbers winnerNumber) {
        return LottoRank.findLottoRank(this, winnerNumber);
    }
}

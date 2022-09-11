package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import weblotto.domain.LottoYield;

import static org.assertj.core.api.Assertions.*;

public class LottoYieldTest {

    @Test
    @DisplayName("수익 통계 일치 확인")
    void lotto_yield_true_test() {
        // given
        double profit = 1;
        LottoYield lottoYield = new LottoYield(profit);
        // when
        boolean actual = lottoYield.checkYield(profit);
        // then
        assertThat(actual).isTrue();
    }

    @Test
    @DisplayName("수익 통계 불일치 확인")
    void lotto_yield_false_test() {
        // given
        double profit = 1;
        double checkProfit = 2;
        LottoYield lottoYield = new LottoYield(profit);
        // when
        boolean actual = lottoYield.checkYield(checkProfit);
        // then
        assertThat(actual).isFalse();
    }

    @Test
    @DisplayName("이익 문자열 확인")
    void string_profit_test() {
        // given
        double profit = 1;
        LottoYield lottoYield = new LottoYield(profit);
        String expected = "이익";
        // when
        String actual = lottoYield.stringYield();
        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("손해 문자열 확인")
    void string_loss_test() {
        // given
        double profit = 0.99;
        LottoYield lottoYield = new LottoYield(profit);
        String expected = "손해";
        // when
        String actual = lottoYield.stringYield();
        // then
        assertThat(actual).isEqualTo(expected);
    }
}

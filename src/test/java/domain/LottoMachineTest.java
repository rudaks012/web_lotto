package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import weblotto.domain.LottoMachine;
import weblotto.domain.LottoQuantity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoMachineTest {

    @ParameterizedTest(name = "로또 금액 대비 개수 확인 :[{index}] : [{arguments}]")
    @DisplayName("로또 금액 대비 개수 확인")
    @CsvSource(value = {
            "11000,11",
            "1000,1"
    })
    void inputLottoAmount(int amount, int ticketCount) {
        // given
        LottoQuantity lottoQuantity = new LottoQuantity(amount);
        // when

        // then
        assertThat(lottoQuantity.lottoQuantity()).isEqualTo(ticketCount);
    }

    @Test
    @DisplayName("로또 구매금액 천원 미만 유효성 확인")
    void zeroAmountExceptionTest() {
        // given
        int amount = 0;
        // when // then
        assertThatThrownBy(() -> new LottoMachine(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

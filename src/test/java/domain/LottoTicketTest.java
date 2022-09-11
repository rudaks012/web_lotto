package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import weblotto.domain.LottoTicket;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoTicketTest {

    public List<Integer> createLottoNumber() {
        return Arrays.asList(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("로또 발급")
    void createLottoTicket() {
        // given
        List<Integer> numbers = createLottoNumber();
        LottoTicket lottoTicket = new LottoTicket(numbers);
        // when
        // then

        assertThat(lottoTicket.lottoNumber()).isEqualTo(numbers);
    }

    @Test
    @DisplayName("로또 번호 6개인지 확인")
    void checkLottoNumberSize() {
        // given
        LottoTicket lottoTicket = new LottoTicket();
        // when
        List<Integer> numbers = lottoTicket.lottoNumber();
        // then
        int actual = numbers.size();
        int expected = 6;
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest(name = "로또 번호 1~45 벗어날 시 예외 확인:[{index}] : [{arguments}]")
    @DisplayName("로또 번호 1~45 벗어날 시 예외 확인")
    @ValueSource(strings = {
            "0,1,2,3,4,45",
            "1,2,3,4,5,46"
    })
    void throw_exception_lotto_number_size_out(String input) {
        assertThatIllegalArgumentException().isThrownBy(()-> new LottoTicket(input));
    }
}

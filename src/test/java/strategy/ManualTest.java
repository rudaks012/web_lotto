package strategy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import weblotto.strategy.Manual;
import weblotto.strategy.Numbers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class ManualTest {

    private String inputWinners;

    @BeforeEach
    public void setUp() {
        inputWinners = "1,2,3,4,5,6";
    }

    private void createWinner(String input) {
        new Manual(input);
    }

    @Test
    @DisplayName("당첨번호 6개 사이즈 확인")
    void winner_number_size_six_test() {
        // given
        Numbers winnerNumber = new Manual(inputWinners);
        // when
        int actual = winnerNumber.readOnlyNumbers().size();
        int expected = 6;
        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("로또 번호 중복 확인")
    void winner_number_duplicate_test() {
        // given
        String input = "1,1,2,3,4,5";
        // when
        assertThatIllegalArgumentException().isThrownBy(() -> createWinner(input));
    }

    @ParameterizedTest(name = "로또 번호 1~45 벗어날 시 예외 확인 :[{index}] : [{arguments}]")
    @DisplayName("로또 번호 1~45 벗어날 시 예외 확인")
    @ValueSource(strings = {
            "0,1,2,3,4,45",
            "1,2,3,4,5,46"
    })
    void throw_exception_winner_number_size_out_one_between_forty_five(String inputWinners) {
        assertThatIllegalArgumentException().isThrownBy(() -> createWinner(inputWinners));
    }

    @ParameterizedTest(name = "로또 번호 중복 얘외 확인 :[{index}] : [{arguments}]")
    @DisplayName("로또 번호 중복 얘외 확인")
    @ValueSource(strings = {
            "1,1,1,1,1,1",
            "1,1,2,3,4,5"
    })
    void throw_exception_winner_number_duplicate(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> createWinner(input));
    }
}

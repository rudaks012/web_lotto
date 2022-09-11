package strategy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import weblotto.strategy.Auto;
import weblotto.strategy.Numbers;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AutoTest {

    public List<Integer> createLottoNumber() {
        return Arrays.asList(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("번호 사이즈 6개 확인")
    void auto_number_size_six_test() {
        // given
        Numbers numbers = new Auto();
        // when
        int actual = numbers.readOnlyNumbers().size();
        int expected = 6;
        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("자동 번호 일치 확인")
    void auto_number_true_test() {
        // given
        List<Integer> intList = createLottoNumber();
        Numbers numbers = new Auto(intList);
        // when
        boolean actual = numbers.checkNumbers(intList);
        // then
        assertThat(actual).isTrue();
    }

    @Test
    @DisplayName("자동 번호 불일치 확인")
    void auto_number_false_test() {
        // given
        List<Integer> intList = createLottoNumber();
        Numbers numbers = new Auto();
        // when
        boolean actual = numbers.checkNumbers(intList);
        // then
        assertThat(actual).isFalse();
    }
}

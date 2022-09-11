package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import weblotto.domain.LottoRank;
import weblotto.domain.LottoTicket;
import weblotto.strategy.Auto;
import weblotto.strategy.Numbers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoRankTest {

    private Numbers winnerNumber;

    public List<Integer> createLottoNumber() {
        return Arrays.asList(1, 2, 3, 4, 5, 6);
    }

    @BeforeEach
    //test가 호출 되기 전에 매번 호출
    public void setUp() {
        winnerNumber = new Auto(createLottoNumber());
    }

    @Test
    @DisplayName("로또 꽝 생성 확인")
    void lottoRankOutTest() {
        // given
        String inputLottoThree = "1,2,42,43,44,45";
        LottoTicket ticket = new LottoTicket(inputLottoThree);
        // when
        // then
        assertThat(ticket.rank(winnerNumber)).isEqualTo(LottoRank.ZERO);
    }

    @ParameterizedTest(name = "로또 번호 일치 수:[{index}] : [{arguments}]")
    @DisplayName("로또 번호 일치 수")
    @MethodSource("matchCount")
    void lotto_rank_match_count(LottoTicket ticket, LottoRank rank) {
        // given
        assertThat(ticket.rank(winnerNumber)).isEqualTo(rank);
        // when
        // then
    }

    private static Stream<Arguments> matchCount() {
        return Stream.of(
                Arguments.of(new LottoTicket("1,2,3,4,5,6"), LottoRank.SIX),
                Arguments.of(new LottoTicket("1,2,3,4,5,7"), LottoRank.FIVE),
                Arguments.of(new LottoTicket("1,2,3,4,8,7"), LottoRank.FOUR),
                Arguments.of(new LottoTicket("1,2,3,9,8,7"), LottoRank.THREE)
        );
    }
}

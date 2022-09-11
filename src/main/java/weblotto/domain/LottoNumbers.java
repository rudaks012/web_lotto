package weblotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbers {
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final String DEFAULT_SPLIT_REGEX = ",";

    private static final List<Integer> LOTTO_NUMBERS = IntStream.range(MIN_NUMBER, MAX_NUMBER)
            .boxed()
            .collect(Collectors.toList());

    private final List<Integer> lottoNumber;

    public LottoNumbers(List<Integer> lottoNumber) {
        this.lottoNumber = extractSixLottoNumbers();
    }

    private List<Integer> extractSixLottoNumbers() {
        return shuffledNumbers().stream()
                .limit(LOTTO_NUMBER_COUNT)
                .collect(Collectors.toList());// 6개 뽑아요

//        Collections.sort(result);// 정렬해요 // 지금 왜 정렬함?? 비교할 때 하면 되잖아

//        return result;
    }

    private List<Integer> shuffledNumbers() {
        List<Integer> numbers = LOTTO_NUMBERS;// 리스트 생성 - 상수는 건들면 안되기 때문에

        Collections.shuffle(numbers); //섞어요
        return numbers;
    }
}

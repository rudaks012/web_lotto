package weblotto.strategy;

import weblotto.Constant;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Manual implements Numbers {
    private static final String DEFAULT_SPLIT_REGEX = ",";

    private final List<Integer> lottoNumbers;

    public Manual(String numbers) {
        this.lottoNumbers = createLottoNumber(numbers);
    }

    @Override
    public List<Integer> readOnlyNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }

    private List<Integer> createLottoNumber(String numbers) {
        List<Integer> result = stringToList(numbers).stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        idsDuplicateNumbers(result);
        isLottoNumberCount(result);
        isWinnerNumbers(result);

        return result;
    }

    private List<String> stringToList(String WinnerNumbers) {
        return Arrays.stream(WinnerNumbers.split(DEFAULT_SPLIT_REGEX))
                .map(String::trim) // 공백함수 제거
                .collect(Collectors.toList());
    }

    private void idsDuplicateNumbers(List<Integer> result) {
        int count = (int) result.stream()
                .distinct() // 중복되는 요소 모드 제거 하고 새로운 스트림을 반환 String 객체가 아니면 equals, hashCode가 재정의 되어야 한다.
                .count();   //현재 원소 갯수를 카운트 해서 long타입으로 리턴

        if (count != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(Constant.LOTTO_NUMBER_DUPLICATE_ERROR);
        }
    }

    private void isLottoNumberCount(List<Integer> result) {
        if (result.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(Constant.LOTTO_NUMBER_COUNT_ERROR);
        }
    }

    private void isWinnerNumbers(List<Integer> result) {
        if (result.stream()
                .anyMatch(this::isLottoNumberSize)) {
            throw new IllegalArgumentException(Constant.LOTTO_NUMBER_SIZE_ERROR);
        }
    }

    private boolean isLottoNumberSize(int number) {
        return (MIN_NUMBER > number) || (MAX_NUMBER < number);
    }

    @Override
    public boolean checkNumbers(List<Integer> numbers) {
        return Objects.equals(numbers, lottoNumbers);
    }
}

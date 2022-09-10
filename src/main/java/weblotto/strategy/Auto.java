package weblotto.strategy;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Auto implements Numbers {

    private static final List<Integer> LOTTO_NUMBERS = IntStream.range(MIN_NUMBER, MAX_NUMBER)
            .boxed()
            //int, long,double 요소를 Integer, Long, Double 요소로 박싱해서 Stream을 생성
            .collect(Collectors.toList());

    private final List<Integer> lottoNumbers;

    public Auto() {
        this.lottoNumbers = createLottoNumbers();
    }

    private List<Integer> createLottoNumbers() {
        List<Integer> numbers = LOTTO_NUMBERS;

        Collections.shuffle(numbers);

        List<Integer> result = numbers.stream()
                .limit(LOTTO_NUMBER_COUNT)
                //일정 개수 만큼 가져와서 새로운 스트림을 리턴,
                .collect(Collectors.toList());

        Collections.sort(result);

        return result;
    }

    public Auto(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }


    @Override
    public List<Integer> readOnlyNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
        //list에 데이터를 추가한 뒤 더이상 데이터 삭제, 추가를 막기 위해서 사용 <- final같은 기능
    }

    @Override
    public boolean checkNumbers(List<Integer> numbers) {
        return Objects.equals(numbers, lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
        //매개값으로 주어진 값들을 이용해서 해시 코드를 생성하는 역할.
    }
}

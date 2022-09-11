package weblotto.view;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_BUY_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNER_NUMBERS_MESSAGE = "방송에서 뽑힌 당첨 번호 6개를 입력해주세요. 쉼표(,)로 구분합니다.";
    //스캐너를 상수화 하면 왜 안될까? 입력값이 다르게 나온다.

    public int inputBuyAmount() {
        System.out.println(INPUT_BUY_AMOUNT_MESSAGE);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public String inputWinnerNumber() {
        System.out.println(INPUT_WINNER_NUMBERS_MESSAGE);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}

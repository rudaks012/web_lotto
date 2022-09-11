package weblotto.controller;

import weblotto.domain.LottoMachine;
import weblotto.domain.LottoYield;
import weblotto.strategy.Manual;
import weblotto.strategy.Numbers;
import weblotto.view.InputView;
import weblotto.view.ResultView;

public class LottoController {

    public void run() {
        InputView inputView = new InputView();
        int buyAmount = inputView.inputBuyAmount();

        LottoMachine lottoMachine = new LottoMachine(buyAmount);

        ResultView resultView = new ResultView();
        resultView.printLottoTicketInfos(lottoMachine);

        String winnerNumbers = inputView.inputWinnerNumber();
        Numbers winnerNumber = new Manual(winnerNumbers);
        LottoYield lottoYield = new LottoYield(lottoMachine.lottoTickets(), winnerNumber);

        resultView.printLottoRanksInfos(lottoMachine.lottoTickets(), winnerNumber);
        resultView.printLottoYield(lottoYield);
    }
}

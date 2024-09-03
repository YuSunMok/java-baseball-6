package baseball.controller;

import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballController {

    private static final int INPUT_SIZE = 3;

    private final InputView inputView;
    private final OutputView outputView;
    private int gameStatus; // 1 새로시작, 2 종료

    public BaseballController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        gameStatus = 1;

        outputView.startGameComment();

        List<Integer> computerInput = new ArrayList<>();
        while (computerInput.size() < INPUT_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerInput.contains(randomNumber)) {
                computerInput.add(randomNumber);
            }
        }

        while (gameStatus == 1) {
            outputView.userActionInputComment();
            List<Integer> userActionInput = inputView.getUserActionInput();

            int ball = 0;
            int strike = 0;
            for(int i = 0; i < INPUT_SIZE; i++) {
                if (computerInput.get(i) == userActionInput.get(i)) {
                    strike++;
                } else if (computerInput.contains(userActionInput.get(i))){
                    ball++;
                }
            }

            outputView.showCompareResult(ball, strike);

            if (strike == INPUT_SIZE) {
                outputView.showTheWinningComment();
                gameStatus = inputView.getUserRestartActionInput();
                if (gameStatus == 1) {
                    computerInput.clear();
                    while (computerInput.size() < INPUT_SIZE) {
                        int randomNumber = Randoms.pickNumberInRange(1, 9);
                        if (!computerInput.contains(randomNumber)) {
                            computerInput.add(randomNumber);
                        }
                    }
                }
            }
        }

        outputView.showGameEndComment();

    }

}

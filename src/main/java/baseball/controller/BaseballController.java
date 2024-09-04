package baseball.controller;

import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BaseballController {

    private static final int INPUT_SIZE = 3;

    private final InputView inputView;
    private final OutputView outputView;
    private int gameStatus; // 1 새로시작, 2 종료
    private List<Integer> computerInput = new ArrayList<>();

    public BaseballController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        outputView.startGameComments();
        initializeGame();

        while (isProgressStatus()) {
            outputView.userActionInputComments();
            List<Integer> userActionInput = inputView.getUserActionInput();

            process(userActionInput);
        }

        outputView.showGameEndComments();
    }

    private void initializeGame() {
        changeGameStatusToProgress();
        getRandomNumberForComputerInput();
    }

    private void changeGameStatusToProgress() {
        gameStatus = 1;
    }

    private void process(List<Integer> userActionInput) {
        int gameEndCondition = compareComputerInputWith(userActionInput);

        if (isGameEndCondition(gameEndCondition)) {
            outputView.showTheWinningComments();
            gameStatus = inputView.getGameStatus();

            if (isProgressStatus()) {
                computerInput.clear();
                getRandomNumberForComputerInput();
            }
        }
    }

    private boolean isProgressStatus() {
        return gameStatus == 1;
    }

    private boolean isGameEndCondition(int numberOfStrike) {
        return numberOfStrike == INPUT_SIZE;
    }

    private int compareComputerInputWith(List<Integer> userActionInput) {
        int ball = 0;
        int strike = 0;
        for(int i = 0; i < INPUT_SIZE; i++) {
            if (Objects.equals(computerInput.get(i), userActionInput.get(i))) {
                strike++;
                continue;
            }
            if (computerInput.contains(userActionInput.get(i))){
                ball++;
            }
        }

        outputView.showCompareResult(ball, strike);

        return strike;
    }

    private void getRandomNumberForComputerInput() {
        while (computerInput.size() < INPUT_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (doesNotContain(randomNumber)) {
                computerInput.add(randomNumber);
            }
        }
    }

    private boolean doesNotContain(int randomNumber) {
        return !computerInput.contains(randomNumber);
    }

}

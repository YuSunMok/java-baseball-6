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
        computerInput = initializeGame();

        while (isProgressStatus()) {
            outputView.userActionInputComments();
            List<Integer> userActionInput = inputView.getUserActionInput();

            process(userActionInput);
        }

        outputView.showGameEndComments();
    }

    private List<Integer> initializeGame() {
        changeGameStatusToProgress();
        return getComputerInput();
    }

    private void changeGameStatusToProgress() {
        gameStatus = 1;
    }

    private void process(List<Integer> userActionInput) {
        int numberOfStrike = compareInput(userActionInput);

        if (isGameEndCondition(numberOfStrike)) {
            outputView.showTheWinningComment();
            gameStatus = inputView.getUserRestartActionInput();

            if (isProgressStatus()) {
                computerInput.clear();
                getRandomComputerInput(computerInput);
            }
        }
    }

    private boolean isProgressStatus() {
        return gameStatus == 1;
    }

    private static boolean isGameEndCondition(int numberOfStrike) {
        return numberOfStrike == INPUT_SIZE;
    }

    private int compareInput(List<Integer> userActionInput) {
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

    private static List<Integer> getComputerInput() {
        List<Integer> computerInput = new ArrayList<>();
        getRandomComputerInput(computerInput);
        return computerInput;
    }

    private static void getRandomComputerInput(List<Integer> computerInput) {
        while (computerInput.size() < INPUT_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (doesNotContain(computerInput, randomNumber)) {
                computerInput.add(randomNumber);
            }
        }
    }

    private static boolean doesNotContain(List<Integer> computerInput, int randomNumber) {
        return !computerInput.contains(randomNumber);
    }

}

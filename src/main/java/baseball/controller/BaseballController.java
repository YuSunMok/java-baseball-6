package baseball.controller;

import baseball.model.BaseballStatus;
import baseball.model.Computer;
import baseball.model.UserActionInputs;
import baseball.view.InputView;
import baseball.view.OutputView;
import baseball.view.View;

public class BaseballController {

    private final View view;
    private Computer computer;
    private int gameStatus; // 1 새로시작, 2 종료

    public BaseballController(InputView inputView, OutputView outputView) {
        this.view = new View(inputView, outputView);
        this.computer = new Computer();
    }

    public void run() {
        view.startGameComments();
        initializeGame();

        while (isProgressStatus()) {
            UserActionInputs userActionInputs = view.userActionInputComments();
            process(userActionInputs);
        }

        view.showGameEndComments();
    }

    private void process(UserActionInputs userActionInputs) {
        BaseballStatus gameEndCondition = computer.compare(userActionInputs);
        view.showCompareResultAt(gameEndCondition);

        if (computer.isGameEndCondition(gameEndCondition)) {
            gameStatus = view.showTheWinningComments();

            if (isProgressStatus()) {
                computer.reStartGeme();
            }
        }
    }

    private void initializeGame() {
        changeGameStatusToProgress();
        computer.getRandomNumberForComputerInput();
    }

    private void changeGameStatusToProgress() {
        gameStatus = 1;
    }

    private boolean isProgressStatus() {
        return gameStatus == 1;
    }

}

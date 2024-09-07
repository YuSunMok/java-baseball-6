package baseball.view;

import baseball.model.BaseballStatus;
import baseball.model.UserActionInputs;

import java.util.List;

public class View {

    private final InputView inputView;
    private final OutputView outputView;

    public View(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void startGameComments() {
        outputView.startGameComments();
    }

    public UserActionInputs userActionInputComments() {
        outputView.userActionInputComments();
        List<Integer> userActionInput = inputView.getUserActionInput();
        return UserActionInputs.of(userActionInput);
    }

    public int showTheWinningComments() {
        outputView.showTheWinningComments();
        return inputView.getGameStatus();
    }

    public void showGameEndComments() {
        outputView.showGameEndComments();
    }

    public void showCompareResultAt(BaseballStatus gameEndCondition) {
        outputView.showCompareResult(gameEndCondition);

    }
}

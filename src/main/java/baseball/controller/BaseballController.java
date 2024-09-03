package baseball.controller;

import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BaseballController {

    public static final int INPUT_SIZE = 3;
    private final InputView inputView;
    private final OutputView outputView;

    public BaseballController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        List<Integer> computerInput = new ArrayList<>();
        Random random = new Random();
        while (computerInput.size() < INPUT_SIZE) {
            int randomValue = random.nextInt(9) + 1;
            if (!computerInput.contains(randomValue)) {
                computerInput.add(randomValue);
            }
        }

        while (true) {
            outputView.startGameComment();
            outputView.userActionInputComment();
            String userActionInput = inputView.getUserActionInput();

        }

    }

}

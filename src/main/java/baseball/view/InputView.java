package baseball.view;


import baseball.Validator;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputView {

    public List<Integer> getUserActionInput() {
        String userInput = Console.readLine();
        Validator.userActionInput(userInput);

        return getUserInputs(userInput);
    }

    public int getGameStatus() {
        int userInput = Integer.parseInt(Console.readLine());
        Validator.userActionInputForGameStatus(userInput);

        return userInput;
    }

    private static List<Integer> getUserInputs(String userInput) {
        return userInput.chars()
                .mapToObj(Character::getNumericValue)
                .toList();
    }
}

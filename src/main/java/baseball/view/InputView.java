package baseball.view;


import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputView {

    public List<Integer> getUserActionInput() {
        String userInput = Console.readLine();

        if (userInput.length() != 3 || !userInput.matches("\\d+")) {
            throw new IllegalArgumentException();
        }

        return userInput.chars()
                .mapToObj(Character::getNumericValue)
                .toList();

    }

    public int getGameStatus() {
        int userInput = 0;
        try {
            userInput = Integer.parseInt(Console.readLine());
            if (userInput != 1 && userInput != 2) {
                throw new IllegalArgumentException();
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
        return userInput;
    }
}

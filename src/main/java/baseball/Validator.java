package baseball;

public class Validator {

    public static void userActionInput(String userInput) {
        if (userInput.length() != 3 || !userInput.matches("\\d+")) {
            throw new IllegalArgumentException();
        }
    }

    public static void userActionInputForGameStatus(int userInput) {
        if (userInput != 1 && userInput != 2) {
            throw new IllegalArgumentException();
        }
    }
}

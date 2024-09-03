package baseball.view;


import java.util.Scanner;

public class InputView {

    private final static Scanner SCANNER = new Scanner(System.in);

    public String getUserActionInput() {
        return SCANNER.nextLine();
    }
}

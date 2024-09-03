package baseball.view;

public class OutputView {

    public void showCompareResult(int ball, int strike) {
        if (ball == 0 && strike == 0) {
            showNothingComment();
            return;
        }
        if (ball == 0) {
            System.out.println(strike + "스트라이크");
            return;
        }
        if (strike == 0) {
            System.out.println(ball + "볼");
            return;
        }
        System.out.println(ball + "볼 " + strike + "스트라이크");
    }

    public void startGameComment() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void userActionInputComment() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void showTheWinningComment() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public void showGameEndComment() {
        System.out.println("게임 종료");
    }

    private void showNothingComment() {
        System.out.println("낫싱");
    }


}

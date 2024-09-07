package baseball.view;

import baseball.model.BaseballStatus;

public class OutputView {

    public void showCompareResult(BaseballStatus baseballStatus) {
        int strike = baseballStatus.getStrike();
        int ball = baseballStatus.getBall();

        if (baseballStatus.isNoting()) {
            showNothingComment();
            return;
        }
        if (baseballStatus.doesNotHaveBall()) {
            System.out.println(strike + "스트라이크");
            return;
        }
        if (baseballStatus.doesNotHaveStrike()) {
            System.out.println(ball + "볼");
            return;
        }
        System.out.println(ball + "볼 " + strike + "스트라이크");
    }

    public void startGameComments() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void userActionInputComments() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void showTheWinningComments() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public void showGameEndComments() {
        System.out.println("게임 종료");
    }

    private void showNothingComment() {
        System.out.println("낫싱");
    }



}

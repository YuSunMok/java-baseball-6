package baseball.model;

import java.util.Objects;

public class BaseballStatus {

    private final int strike;
    private final int ball;

    private BaseballStatus(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public static BaseballStatus of(int strike, int ball) {
        return new BaseballStatus(strike, ball);
    }

    public boolean isGameEndCondition(int gameEndCondition) {
        return strike == gameEndCondition;
    }

    public boolean isNoting() {
        return ball == 0 && strike == 0;
    }

    public boolean doesNotHaveBall() {
        return ball == 0;
    }

    public boolean doesNotHaveStrike() {
        return strike == 0;
    }

    public int getStrike() {
        return this.strike;
    }

    public int getBall() {
        return this.ball;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseballStatus that = (BaseballStatus) o;
        return strike == that.strike && ball == that.ball;
    }

    @Override
    public int hashCode() {
        return Objects.hash(strike, ball);
    }
}

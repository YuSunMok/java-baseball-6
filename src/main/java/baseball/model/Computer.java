package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Computer {

    private static final int BASEBALL_SIZE = 3;

    private final List<Integer> computerInput;

    public Computer() {
        this.computerInput = new ArrayList<>();
    }

    public BaseballStatus compare(UserActionInputs userActionInputs) {
        List<Integer> userActionInputList = userActionInputs.getList();
        return getBaseballStatus(userActionInputList);
    }

    private BaseballStatus getBaseballStatus(List<Integer> userActionInputList) {
        int strike = 0;
        int ball = 0;

        for(int i = 0; i < BASEBALL_SIZE; i++) {
            if (isStrike(userActionInputList, i)) {
                strike++;
                continue;
            }
            if (isBall(userActionInputList, i)){
                ball++;
            }
        }

        return BaseballStatus.of(strike, ball);
    }

    public void reStartGeme() {
        inputClear();
        getRandomNumberForComputerInput();
    }

    public void getRandomNumberForComputerInput() {
        while (computerInput.size() < BASEBALL_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (doesNotContain(randomNumber)) {
                computerInput.add(randomNumber);
            }
        }
    }

    public void inputClear() {
        computerInput.clear();
    }

    private boolean isBall(List<Integer> userActionInputList, int i) {
        return computerInput.contains(userActionInputList.get(i));
    }

    private boolean isStrike(List<Integer> userActionInputList, int i) {
        return Objects.equals(computerInput.get(i), userActionInputList.get(i));
    }

    private boolean doesNotContain(int randomNumber) {
        return !computerInput.contains(randomNumber);
    }

    public boolean isGameEndCondition(BaseballStatus status) {
        return status.isGameEndCondition(BASEBALL_SIZE);
    }

}

package baseball.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserActionInputs {

    private final List<Integer> userActionInput;

    private UserActionInputs(List<Integer> userActionInput) {
        this.userActionInput = userActionInput;
    }

    public static UserActionInputs of(List<Integer> userActionInput) {
        return new UserActionInputs(userActionInput);
    }

    public List<Integer> getList() {
        return new ArrayList<>(userActionInput);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserActionInputs that = (UserActionInputs) o;
        return Objects.equals(userActionInput, that.userActionInput);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userActionInput);
    }
}

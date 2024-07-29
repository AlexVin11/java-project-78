package hexlet.code;

import java.util.Objects;
import java.util.function.Predicate;

public class NumberSchema extends BasicSchema<Integer>{
    private final String NUMBER_IS_POSITIVE = "positive";
    private final String NUMBER_IN_RANGE = "range";

    public NumberSchema required() {
        Predicate<Integer> requiredPredicate = e -> !Objects.isNull(e);
        this.addCheck(IS_REQUIRED, requiredPredicate);
        return this;
    }

    public NumberSchema positive() {
        Predicate<Integer> positive = e -> {
            if (e == 0) {
                return false;
            } else if (e > 0) {
                return true;
            } else {
                return false;
            }
        };
        addCheck(NUMBER_IS_POSITIVE, positive);
        return this;
    }

    public NumberSchema range(Integer a, Integer b) {
        Predicate<Integer> rangePredicate = e -> e >= a && e <= b;
        addCheck(NUMBER_IN_RANGE, rangePredicate);
        return this;
    }
}

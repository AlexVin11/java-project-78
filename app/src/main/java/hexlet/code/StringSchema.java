package hexlet.code;

import java.util.Objects;
import java.util.function.Predicate;

public class StringSchema extends BasicSchema<String> {
    private final String minLengthCheckName = "minLength";
    private final String containsCheckName = "contains";

    public StringSchema required() {
        Predicate<String> requiredPredicate = e -> !Objects.isNull(e) && !e.equals("");
        this.addCheck(IS_REQUIRED, requiredPredicate);
        return this;
    }

    public StringSchema minLength(int number) {
        Predicate<String> isMinLength = e -> e.length() >= number;
        this.addCheck(minLengthCheckName, isMinLength);
        return this;
    }

    public StringSchema contains(String str) {
        Predicate<String> containsPredicate = e -> e.contains(str);
        this.addCheck(containsCheckName, containsPredicate);
        return this;
    }
}

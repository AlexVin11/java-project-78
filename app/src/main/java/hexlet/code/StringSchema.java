package hexlet.code;


import java.util.Objects;
import java.util.function.Predicate;

public class StringSchema extends BasicSchema {
    private final String REQUIRED_CHECK_NAME = "required";
    private final String MIN_LENGTH_CHECK_NAME = "minLength";
    private final String CONTAINS_CHECK_NAME = "contains";

    public void required() {
        Predicate<Objects> required = e -> Objects.nonNull(e);
        this.addCheck(REQUIRED_CHECK_NAME, required);
    }

    public void minLength(int number) {
        Predicate<String> minLength = e -> e.length() <= number;
        this.addCheck(MIN_LENGTH_CHECK_NAME, minLength);
    }

    public void contains(String str) {
        Predicate<String> contains = e -> e.contains(str);
        this.addCheck(CONTAINS_CHECK_NAME, contains);
    }

    @Override
    public boolean isValid(Objects obj) {
        var processedObj = obj.toString();
        for (var entrys : this.checks.entrySet()) {
            var checkName = entrys.
        }
        if (checks.containsKey("required")) {
            var predicate = checks.get("required");
        }
    }
}

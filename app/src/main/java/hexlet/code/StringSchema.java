package hexlet.code;


import java.util.function.Predicate;

public class StringSchema extends BasicSchema {
    private final String REQUIRED = "required";
    private final String MIN_LENGTH = "minLength";

    public void isRequired() {
        this.required = true;
    }

    public void minLength(int number) {
        Predicate<Integer> minLengthPredicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer number) {
                return false;
            }
        };
        this.checks.put(MIN_LENGTH, minLengthPredicate);
    }

    public void contains(String str) {
        Predicate<String> containsPredicate = new Predicate<String>() {
            @Override
            public boolean test(String str) {
                return false;
            }
        };
    }

    @Override
    public boolean isValid() {
        return false;
    }
}

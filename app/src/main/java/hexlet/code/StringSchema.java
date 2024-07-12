package hexlet.code;


import java.util.function.Predicate;

public class StringSchema extends BasicSchema {
    private final String REQUIRED = "required";
    private final String MIN_LENGTH = "minLength";

    public void isRequired() {
        this.required = true;
    }

    public void minLength(int number) {
        Predicate<BasicSchema> minLengthPredicate = e ->
        this.checks.put(MIN_LENGTH, )
    }

    public void contains(String str) {

    }

    @Override
    public boolean isValid() {
        return false;
    }
}

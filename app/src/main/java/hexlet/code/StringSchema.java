package hexlet.code;


import java.util.function.Predicate;

public class StringSchema extends BasicSchema<String> {

    public StringSchema required() {
        setRequired();
        return this;
    }

    public StringSchema minLength(int number) {
        Predicate<String> minLength = e -> e.length() >= number;
        updateCheck(minLength);
        return this;
    }

    public StringSchema contains(String str) {
        Predicate<String> contains = e -> e.contains(str);
        updateCheck(contains);
        return this;
    }

    @Override
    public boolean isValid(String str) {
        if (this.required == false) {
            return true;
        } else {
            for (var check : this.checks) {
                if (!check.test(str)) {
                    return false;
                } else {
                    return true;
                }
            }
        }
        return false;
    }
}

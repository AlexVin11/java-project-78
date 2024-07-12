package hexlet.code;


import java.util.function.Predicate;

public class StringSchema extends BasicSchema {
    private Boolean isRequired;
    private Integer minLength;
    private String contains;

    public boolean isRequired() {
        this.isRequired = true;
        Predicate<StringSchema> isRequired = this -> {
            if (this.isRequired == null) {
                return true;
            } else {
                return false;
            }
        }
        this.checks.put("isReuided", isRequired);
    }

    public void minLength(int number) {
        this.minLength = number;
    }

    public void contains(String str) {
        this.contains += str;
    }

    @Override
    public boolean isValid() {
        if (this.checks.isEmpty()) {
            return true;
        } else if (this.checks.containsKey("isRequired")) {

        }
        return false;
    }
}

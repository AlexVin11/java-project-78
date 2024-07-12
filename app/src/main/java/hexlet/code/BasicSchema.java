package hexlet.code;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;

public abstract class BasicSchema<T> {
    protected Map<String, Predicate<T>> checks = new LinkedHashMap<>();
    protected boolean required = false;

    protected final void addCheck(String checkName, Predicate<T> predicate) {
        checks.put(checkName, predicate);
    }

    public abstract boolean isValid();
}

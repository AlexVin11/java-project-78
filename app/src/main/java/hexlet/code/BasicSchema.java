package hexlet.code;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

public class BasicSchema<T> {
    protected Map<String, Predicate<T>> checks = new LinkedHashMap<>();
    protected final String IS_REQUIRED = "required";

    protected final void addCheck(String name, Predicate<T> predicate) {
        checks.put(name, predicate);
    }

    protected boolean isValid(T t) {
        if (checks.containsKey(IS_REQUIRED)) {
            if (!checks.get(IS_REQUIRED).test(t)) {
                return false;
            }
        } else {
            if (Objects.isNull(t)) {
                return true;
            }
        }
        for (var check : checks.keySet()) {
            var predicate = checks.get(check);
            if (!predicate.test(t)) {
                return false;
            }
        }
        return true;
    }
}

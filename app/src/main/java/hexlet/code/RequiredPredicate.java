package hexlet.code;

import java.util.Map;
import java.util.function.Predicate;

public class RequiredPredicate<T> implements Predicate<T> {

    @Override
    public boolean test(T t) {
        return false;
    }
}

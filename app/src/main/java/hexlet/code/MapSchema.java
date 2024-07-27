package hexlet.code;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

public class MapSchema<T> extends BasicSchema<Map> {
    private final String SHAPE = "shape";
    private final String SIZE_OF_MAP = "size";

    public MapSchema required() {
        Predicate<Map> requiredPredicate = e -> !Objects.isNull(e) && (e instanceof HashMap);
        if (this.checks.containsKey(IS_REQUIRED)) {
            updateCheck(IS_REQUIRED, requiredPredicate);
        } else {
            this.addCheck(IS_REQUIRED, requiredPredicate);
        }
        return this;
    }

    public MapSchema sizeof(int size) {
        Predicate<Map> sizeOfPredicate = e -> e.size() == size;
        if (this.checks.containsKey(SIZE_OF_MAP)) {
            updateCheck(SIZE_OF_MAP, sizeOfPredicate);
        } else {
            this.addCheck(SIZE_OF_MAP, sizeOfPredicate);
        }
        return this;
    }

    public MapSchema shape(Map<String, BasicSchema<T>> keyAndConfiguration) {
        Predicate<Map> shapePredicate = e -> {
            var entrys = ((Map<String, T>)e).entrySet();
            for (var entry : entrys) {
                var key = entry.getKey();
                var value = entry.getValue();
                var schema = keyAndConfiguration.get(key);
                if (schema.isValid(value)) {
                    return true;
                };
            }
            return false;
        };
        if (this.checks.containsKey(SHAPE)) {
            updateCheck(SHAPE, shapePredicate);
        } else {
            this.addCheck(SHAPE, shapePredicate);
        }
        return this;
    }
}

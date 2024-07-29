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
        this.addCheck(IS_REQUIRED, requiredPredicate);
        return this;
    }

    public MapSchema sizeof(int size) {
        Predicate<Map> sizeOfPredicate = e -> e.size() == size;
        this.addCheck(SIZE_OF_MAP, sizeOfPredicate);
        return this;
    }

    public <T> MapSchema shape(Map<String, BasicSchema<T>> schemas) {
        addCheck(SHAPE,
                map -> {
            return schemas.entrySet().stream().allMatch(e -> {
                var k = map.get(e.getKey());
                var schema = e.getValue();
                return schema.isValid((T) k);
            });
                });
        return this;
    }
}

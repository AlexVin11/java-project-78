package hexlet.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapSchemaTest {
    private static MapSchema mapSchema;

    @BeforeEach
    public void beforeEach() {
        mapSchema = Validator.map();
    }

    @Test
    public void nullableTestIsValid() {
        assertEquals(true, mapSchema.isValid(null));
        assertEquals(true, mapSchema.isValid(new HashMap()));
        var data = new HashMap<String, String>();
        data.put("key1", "value1");
        mapSchema.required();
        assertEquals(true, mapSchema.isValid(data));
        mapSchema.sizeof(2);
        assertEquals(false, mapSchema.isValid(data));
        data.put("key2", "value2");
        assertEquals(true, mapSchema.isValid(data));
    }
}

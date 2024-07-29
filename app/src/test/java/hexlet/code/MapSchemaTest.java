package hexlet.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapSchemaTest {
    private static Validator validator = new Validator();
    private static MapSchema mapSchema = validator.map();

    @Test
    public void TestIsValid() {
        assertEquals(true, mapSchema.isValid(null));
        assertEquals(true, mapSchema.isValid(new HashMap()));
        mapSchema.required();
        assertEquals(false, mapSchema.isValid(null));
        assertEquals(true, mapSchema.isValid(new HashMap()));
        assertEquals(true, mapSchema.isValid(new LinkedHashMap()));
        var data = new HashMap<String, String>();
        data.put("key1", "value1");
        assertEquals(true, mapSchema.isValid(data));
        mapSchema.sizeof(2);
        assertEquals(false, mapSchema.isValid(data));
        data.put("key2", "value2");
        assertEquals(true, mapSchema.isValid(data));
        Map<String, BasicSchema<String>> stringValidationSchemas = new HashMap<>();
        Map<String, BasicSchema<Integer>> numberValidationSchemas = new HashMap<>();
        stringValidationSchemas.put("firstName", validator.string().required());
        stringValidationSchemas.put("lastName", validator.string().required().minLength(2));
        numberValidationSchemas.put("phoneNumber", validator.number().required());
        numberValidationSchemas.put("zip", validator.number().required().positive());
        mapSchema.shape(stringValidationSchemas);
        Map<String, String> person1 = new HashMap<>();
        person1.put("firstName", "John");
        person1.put("lastName", "Smith");
        assertEquals(true, mapSchema.isValid(person1));
        Map<String, String> person2 = new HashMap<>();
        person2.put("firstName", null);
        person2.put("lastName", "Smith");
        assertEquals(false, mapSchema.isValid(person2));
        Map<String, String> person3 = new HashMap<>();
        person3.put("firstName", "John");
        person3.put("lastName", "S");
        assertEquals(false, mapSchema.isValid(person3));
        mapSchema.shape(numberValidationSchemas);
        Map<String, Integer> address1 = new HashMap<>();
        address1.put("phoneNumber", null);
        address1.put("zip", 123456);
        assertEquals(false, mapSchema.isValid(address1));
        Map<String, Integer> address2 = new HashMap<>();
        address2.put("phoneNumber", 123456);
        address2.put("zip", 123456);
        assertEquals(true, mapSchema.isValid(address2));
        Map<String, Integer> address3 = new HashMap<>();
        address3.put("phoneNumber", 123456);
        address3.put("zip", -123456);
        assertEquals(false, mapSchema.isValid(address3));
    }
}

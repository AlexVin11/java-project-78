package hexlet.code;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringSchemaTest {
    private static StringSchema stringSchema;

    @BeforeAll
    public static void beforeAll() {
        stringSchema = Validator.string();
    }

    @Test
    public void nullableTestIsValid() {
        assertEquals(true, stringSchema.isValid(""));
        assertEquals(true, stringSchema.isValid(null));
        assertEquals(true, stringSchema.isValid("what does the fox say"));
        assertEquals(true, stringSchema.isValid("hexlet"));
        stringSchema.required();
        assertEquals(false, stringSchema.isValid(""));
        assertEquals(false, stringSchema.isValid(null));
    }

    @Test
    public void conatainsTestIsValid() {
        stringSchema.required();
        assertEquals(true, stringSchema.isValid("what does the fox say"));
        stringSchema = stringSchema.contains("wh");
        assertEquals(true, stringSchema.isValid("what does the fox say"));
        stringSchema = stringSchema.contains("what");
        assertEquals(true, stringSchema.isValid("what does the fox say"));
        stringSchema = stringSchema.contains("whatthe");
        assertEquals(false, stringSchema.isValid("what does the fox say"));
    }

    @Test
    public void testMinLength() {
        stringSchema.required();
        stringSchema.minLength(10).minLength(4);
        assertEquals(true, stringSchema.isValid("Hexl"));
    }

    @Test
    public void complexTestIsValid() {
        stringSchema.required().minLength(5).minLength(4).contains("hex");
        assertEquals(false, stringSchema.isValid("hex"));
        assertEquals(false, stringSchema.isValid("mako"));
        assertEquals(true, stringSchema.isValid("hexl"));
    }
}

package hexlet.code;

import hexlet.code.schemas.NumberSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberSchemaTest {
    private static NumberSchema numberSchema;

    @BeforeEach
    public final void beforeEach() {
        numberSchema = Validator.number();
    }

    @Test
    public void testIsValidBasic() {
        assertEquals(true, numberSchema.isValid(5));
        assertEquals(true, numberSchema.isValid(null));
        numberSchema.positive();
        assertEquals(true, numberSchema.isValid(null));
        numberSchema.required();
        assertEquals(false, numberSchema.isValid(null));
        assertEquals(true, numberSchema.isValid(10));
        assertEquals(false, numberSchema.isValid(-10));
        assertEquals(false, numberSchema.isValid(0));
        assertEquals(true, numberSchema.isValid(2147483647));
        assertEquals(false, numberSchema.isValid(-2147483647));
    }

    @Test
    public void testIsValidMinMaxBorder() {
        numberSchema.required();
        assertEquals(true, numberSchema.isValid(2147483647));
        assertEquals(true, numberSchema.isValid(-2147483647));
    }

    @Test
    public void testIsValidWithRange() {
        numberSchema.range(-5, 10);
        assertEquals(true, numberSchema.isValid(null));
        assertEquals(false, numberSchema.isValid(100));
        assertEquals(false, numberSchema.isValid(2147483647));
        assertEquals(false, numberSchema.isValid(-2147483647));
        assertEquals(true, numberSchema.isValid(-5));
        assertEquals(true, numberSchema.isValid(-4));
        assertEquals(true, numberSchema.isValid(0));
        assertEquals(true, numberSchema.isValid(10));
        assertEquals(true, numberSchema.isValid(9));
        numberSchema.required();
        assertEquals(false, numberSchema.isValid(null));
        assertEquals(false, numberSchema.isValid(2147483647));
        assertEquals(false, numberSchema.isValid(-2147483647));
    }

    @Test
    public void testIsValidComplex() {
        numberSchema.required().positive().range(-5, 10);
        assertEquals(false, numberSchema.isValid(-5));
        assertEquals(false, numberSchema.isValid(-4));
        assertEquals(false, numberSchema.isValid(0));
        assertEquals(true, numberSchema.isValid(1));
        assertEquals(true, numberSchema.isValid(10));
        assertEquals(true, numberSchema.isValid(9));
    }
}

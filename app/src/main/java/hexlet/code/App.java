package hexlet.code;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello, world!");
        var schema = Validator.string();
        System.out.println(schema.isValid(""));
        System.out.println(schema.isValid(null));
        schema.required();
        System.out.println(schema.isValid(""));
        System.out.println(schema.isValid(null));
        System.out.println("contains str in isValid(\"str\") result is " + schema.contains("str").isValid("str") + " should be true");
        System.out.println("contains strtt in isValid(\"str\") result is " + schema.contains("strtt").isValid("str") + " should be false");
        System.out.println("contains figma in isValid(\"strtt\") result is " + schema.contains("figma").isValid("strtt") + " should be false");
        System.out.println("contains milky in isValid(\"str\") result is " + schema.contains("milky").isValid("str") + " should be false");
        System.out.println("contains whathe in isValid(\"what does the fox say\") result is " + schema.contains("whathe").isValid("what does the fox say") + " should be false");
    }
}

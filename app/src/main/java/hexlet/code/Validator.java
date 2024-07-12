package hexlet.code;


import java.util.ArrayList;

public class Validator {
    //список созданных схем валидации
    ArrayList<BasicSchema> schemas;

    public StringSchema string() {
        var createdSchema = new StringSchema();
        schemas.add(createdSchema);
        return createdSchema;
    }
}

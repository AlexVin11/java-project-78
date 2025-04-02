### Hexlet tests and linter status:
[![Actions Status](https://github.com/AlexVin11/java-project-78/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/AlexVin11/java-project-78/actions)
[![Maintainability](https://api.codeclimate.com/v1/badges/7481efed2b3985ac91fa/maintainability)](https://codeclimate.com/github/AlexVin11/java-project-78/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/7481efed2b3985ac91fa/test_coverage)](https://codeclimate.com/github/AlexVin11/java-project-78/test_coverage)

# Project overview
Project represents a validator for data that user want to check. App using a fluent interface so user can config a rules of validation.
Basic usage scenario look like this:
1. Create a variable for Validator: var v = new Validator();
2. Create a scheme that will be used in further validation- it depends on data type. For string validation you need to create a StringSchema, for numbers NumberSchema and for Map MapSchema. It can be done this way- v.string(), v.number() and v.map();
3. StringSchema contains a few of properties- .required() - if given string is empty or null return false, .contains("str") - given string should contain a given substring, .minLength(int min) - given string should be longer or same length as was set up.
4. NumberSchema contains properties: .required() - if user gives empty or null input it return false, .positive() - given number should be positive, .range(int min, int max) - given number must be in given range. 
5. MapSchema contains properties: .required() - if empty or null input it return false, .size(int min) - given map must greater or equal given size.
MapSchema has .shape() method that allows user to configure the list of checks for given property.
For example we will create a string and list of checks for it.
Example of usage .shape() looks like this: 
1. Go to step 1 and 2 (we would need v.map()).
2. For string we create a map that contains checks: Map<String, BaseSchema<String>> schemas = new HashMap<>();
3. Lets create a string and list of checks for it: schemas.put("firstName", v.string().required()); schemas.put("lastName", v.string().required().minLength(2));
4. schema.shape(schemas) now we have a map with property (firstName and lastName) and list of checks specified for these properties.
5. Now we will create a map for checking: Map<String, String> human1 = new HashMap<>();, and fill it with data: human1.put("firstName", "John"); human1.put("lastName", "Smith");
6. Now we can check map we created on step 5. schema.isValid(human1);//it will return true
How it works: human1 has firstName and constraints for it- it should not be empty or null. lastName and constraints for it- it should not be empty or null and it must be longer or equals 2 symbols. All checks are successful.
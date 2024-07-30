### Hexlet tests and linter status:
[![Actions Status](https://github.com/AlexVin11/java-project-78/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/AlexVin11/java-project-78/actions)
[![Maintainability](https://api.codeclimate.com/v1/badges/7481efed2b3985ac91fa/maintainability)](https://codeclimate.com/github/AlexVin11/java-project-78/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/7481efed2b3985ac91fa/test_coverage)](https://codeclimate.com/github/AlexVin11/java-project-78/test_coverage)

# Project overview
Project represents a validator for data that user want to check. App using a fluent interface so user can config a rules of validation.
Basic usage scenario look like this:
1. Create a variable for Validator var v = new Validator();
2. Create a scheme that will be used in further validation- it depends on data type. For string validation you need to create a StringSchema. It can be done this way- v.string();
3. StringSchema contains a few of properties- .required() - if given string is empty or null return false, .contains() - given string should contain a given substring, .minLength() - given string should be longer or same length as was set up.
4. Same logic for NumberSchema (for Integers) and MapSchema (for Map)
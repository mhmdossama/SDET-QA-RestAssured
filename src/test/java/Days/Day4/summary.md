# Validate response data restassured
- Validate response data in RestAssured
- RestAssured is a Java library that simplifies the process of testing RESTful web services.
- It provides a domain-specific language (DSL) for writing tests for REST APIs.

- How to validate response data in RestAssured:
  - Use the `assertThat()` method to validate response data.
  - Use matchers from the `org.hamcrest` library to perform assertions on the response data.
  - Common matchers include:
    - `equalTo()`: Checks if the actual value is equal to the expected value.
    - `containsString()`: Checks if the actual string contains the expected substring.
    - `hasKey()`: Checks if a JSON object has a specific key.
    - `hasSize()`: Checks if a collection has a specific size.
    - `not()`: Negates the assertion.
    - `is()`: Checks if the actual value is equal to the expected value.
    - `greaterThan()`: Checks if the actual value is greater than the expected value.
    - `lessThan()`: Checks if the actual value is less than the expected value.
    - `notNullValue()`: Checks if the actual value is not null.
    - `nullValue()`: Checks if the actual value is null.
    - `instanceOf()`: Checks if the actual value is an instance of a specific class.
    - `hasItems()`: Checks if a collection contains specific items.
    - `hasEntry()`: Checks if a map contains a specific key-value pair.
    - `hasValue()`: Checks if a JSON object has a specific value.
  


    
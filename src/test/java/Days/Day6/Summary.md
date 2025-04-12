## RestAssured
### JSON/XML schema validation

- **JSON Schema Validation**: Validates JSON responses against a defined schema.
- **XML Schema Validation**: Validates XML responses against a defined schema.
- What is a schema? A schema is a blueprint or structure that defines the expected format and content of a JSON or XML document. 
  - It specifies the data types, required fields, and relationships between different elements in the document.
- What is the difference between schema and response? 
  - A schema is a predefined structure that describes how data should be organized, while a response is the actual data returned by an API after a request. 
  - The response should conform to the schema to ensure it meets the expected format and content.

### How to validate JSON/XML schema in RestAssured
- **JSON Schema Validation**:
  - Use the `jsonSchema()` method to validate JSON responses against a schema.
  - Example:
    ```java
    given()
        .when()
        .get("/api/users")
        .then()
        .assertThat()
        .body(matchesJsonSchemaInClasspath("user-schema.json"));
    ```
    - In this example, the response from the `/api/users` endpoint is validated against the `user-schema.json` file located in the classpath.
    - The `matchesJsonSchemaInClasspath()` method checks if the response matches the defined schema.
    - If the response does not conform to the schema, an assertion error will be thrown, indicating the validation failure.
- **XML Schema Validation**:
  - Use the `xmlSchema()` method to validate XML responses against a schema.
  - Example:
    ```java
    given()
        .when()
        .get("/api/users")
        .then()
        .assertThat()
        .body(matchesXsdInClasspath("user-schema.xsd"));
    ```
    - In this example, the response from the `/api/users` endpoint is validated against the `user-schema.xsd` file located in the classpath.
    - The `matchesXsdInClasspath()` method checks if the response matches the defined schema.
    - If the response does not conform to the schema, an assertion error will be thrown, indicating the validation failure.

### Serialization and Deserialization
- **Serialization**: The process of converting a Java object into a JSON or XML representation.
- **Deserialization**: The process of converting a JSON or XML representation back into a Java object.
- This is useful for sending requests with complex data structures or parsing responses into Java objects.
- RestAssured provides built-in support for serialization and deserialization using libraries like Jackson or Gson.
- You can use the `given()` method to specify the request body and the `as()` method to specify the expected response type.
- Example:
  ```java
  // Serialization
  User user = new User("John", "Doe");
  given()
      .contentType(ContentType.JSON)
      .body(user)
      .when()
      .post("/api/users")
      .then()
      .statusCode(201);

  // Deserialization
  User responseUser = given()
      .when()
      .get("/api/users/1")
      .then()
      .extract()
      .as(User.class);
  ```
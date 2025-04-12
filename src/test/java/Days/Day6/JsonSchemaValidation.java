package Days.Day6;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class JsonSchemaValidation {
    // Schema Validation using RestAssured
    // 1. Create a JSON schema file (schema.json) with the required structure.
    String jsonSchema = "schema.json"; // Ensure this file is in the classpath (e.g., src/test/resources)
    String baseUrl = "https://reqres.in/api/";

    @Test
    public void jsonSchemaValidation() {
        // Validate the JSON response against the schema
        given().baseUri(baseUrl)
                .when()
                .get("users")
                .then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath(jsonSchema));
    }
}
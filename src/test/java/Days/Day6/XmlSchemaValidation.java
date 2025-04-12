package Days.Day6;

import io.restassured.matcher.RestAssuredMatchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
public class XmlSchemaValidation {

    // XML Schema Validation using RestAssured
    // 1. Create an XML schema file (schema.xsd) with the required structure.
    String xmlSchema = "schema.xsd"; // Ensure this file is in the classpath (e.g., src/test/resources)
    String baseUrl = "https://mocktarget.apigee.net/xml";


        @Test
        public void xmlSchemaValidation() {
            // Validate the XML response against the schema
            given().baseUri(baseUrl)
                    .when()
                    .get()
                    .then()
                    .assertThat()
                    .body(RestAssuredMatchers.matchesXsdInClasspath(xmlSchema));
        }
    @Test
    public void getXml() {
        // Validate the XML response against the schema
        given().baseUri(baseUrl)
                .when()
                .get()
                .then()
                .assertThat()
                .statusCode(200)
                .contentType("application/xml")
                .log().body();
    }
}

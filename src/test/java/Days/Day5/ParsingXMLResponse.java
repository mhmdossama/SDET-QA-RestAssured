package Days.Day5;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ParsingXMLResponse {

    @Test
    public void parsingXMLResponse() {
        String baseUrl = "https://calendarific.com/api/v2/";
        Response response = given().baseUri(baseUrl).contentType("application/xml")
                .when()
                .get("holidays/2025/EG")
                .then()
                .extract().response();

        // Assert that the content type is XML
        System.out.println(response);
        assertThat(response.getContentType(), equalTo("application/xml; charset=utf-8"));
    }
}
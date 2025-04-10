package Days.Day4;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * This class contains test methods to validate API responses using RestAssured and Hamcrest matchers.
 */
public class ValidateResponseData {

    /**
     * Validates the response data from the "users" endpoint of the Reqres API.
     * It checks the status code, status line, content type, response time, and specific fields in the response body.
     */
    @Test
    public void validateResponseData() {
        System.out.println("Validating response data...");

        String baseUrl = "https://reqres.in/api/";

        // Send a GET request to the "users" endpoint with a query parameter and extract the response
        Response response = given().baseUri(baseUrl).queryParam("page", 2)
                .when().get("users")
                .then().extract().response();

        // Assert the status code is 200
        int statusCode = response.getStatusCode();
        System.out.println("Status code: " + statusCode);
        assertThat("Status code is not 200", statusCode, is(200));

        // Assert the status line is "HTTP/1.1 200 OK"
        String statusLine = response.getStatusLine();
        System.out.println("Status line: " + statusLine);
        assertThat("Status line is not HTTP/1.1 200 OK", statusLine, equalTo("HTTP/1.1 200 OK"));

        // Assert the content type is "application/json; charset=utf-8"
        String contentType = response.getContentType();
        System.out.println("Content type: " + contentType);
        assertThat("Content type is not application/json; charset=utf-8", contentType, equalTo("application/json; charset=utf-8"));

        // Assert the response time is less than 2000ms
        long responseTime = response.getTime();
        System.out.println("Response time: " + responseTime);
        assertThat("Response time is greater than 2000ms", responseTime, lessThan(2000L));

        // Assert the response body contains specific fields
        String responseBody = response.getBody().asString();
        System.out.println("Response body: " + responseBody);
        assertThat("Response body does not contain page", responseBody, containsString("page"));
        assertThat("Response body does not contain per_page", responseBody, containsString("per_page"));
        assertThat("Response body does not contain total", responseBody, containsString("total"));
        assertThat("Response body does not contain total_pages", responseBody, containsString("total_pages"));
        assertThat("Response body does not contain data", responseBody, containsString("data"));
        assertThat("Response body does not contain id", responseBody, containsString("id"));
        assertThat("Response body does not contain email", responseBody, containsString("email"));
        assertThat("Response body does not contain first_name", responseBody, containsString("first_name"));
        assertThat("Response body does not contain last_name", responseBody, containsString("last_name"));
        assertThat("Response body does not contain avatar", responseBody, containsString("avatar"));
        assertThat("Response body does not contain support", responseBody, containsString("support"));
        assertThat("Response body does not contain url", responseBody, containsString("url"));
        assertThat("Response body does not contain text", responseBody, containsString("text"));
    }

    /**
     * Extracts the "data" array from the response of the "users" endpoint of the Reqres API.
     * Prints the extracted data to the console.
     */
    @Test
    public void validateResponseData1() {
        System.out.println("Validating response data...");

        String baseUrl = "https://reqres.in/api/";

        // Extract the "data" array from the response
        List<Map<String, Object>> data = given().baseUri(baseUrl).queryParam("page", 2)
                .when().get("users")
                .then().extract().response().path("data");
        System.out.println(data);
    }

    /**
     * Extracts specific data (first name of the first user) from the response of the "users" endpoint of the Reqres API.
     * Validates that the response contains a specific first name.
     */
    @Test
    public void extractingSpecificData() {
        System.out.println("Validating response data...");

        String baseUrl = "https://reqres.in/api/";

        // Extract the first name of the first user from the "data" array
        List<String> data = given().baseUri(baseUrl).queryParam("page", 2)
                .when().get("users")
                .then().extract().response().path("data[0].first_name");
        System.out.println(data);

        // Assert that the response contains the first name "Michael"
        assertThat("Response body does not contain first_name", data, hasItem("Michael"));
    }

    /**
     * Validates the response data from the "products" endpoint of the Fake Store API.
     * Extracts the "price" field, calculates the sum of all prices, and prints the result.
     */
    @Test
    public void validateResponseData2() {
        System.out.println("Validating response data...");

        String baseUrl = "https://fakestoreapi.com/";

        // Extract the "price" field as a list of Double values
        List<Double> price = given().baseUri(baseUrl)
                .when().get("products")
                .then().extract().jsonPath().getList("price", Double.class);

        // Calculate the sum of all prices
        double sum = 0;
        for (int i = 0; i < price.size(); i++) {
            sum += Double.parseDouble(price.get(i).toString());
        }

        // Print the sum and the list of prices
        System.out.println("Sum of all prices: " + sum);
        System.out.println("Prices " + price);
    }
}
package Days.Day3;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class loggingPractice {
    //logging
    //log().all() - logs all the details of the request and response
    //log().uri() - logs the URI of the request
    //log().body() - logs the body of the request
    //log().headers() - logs the headers of the request
    //log().cookies() - logs the cookies of the request
    //log().status() - logs the status code of the response
    //log().ifError() - logs the response only if there is an error

    @Test
    public void logging() {
        String baseUrl = "https://reqres.in/api/users";
        given().log().headers()
                .when()
                .get(baseUrl)
                .then()
                .log().all();
    }
}

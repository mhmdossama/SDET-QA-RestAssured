package Days.Day3;

import io.restassured.http.Headers;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class HeadersDemo {
    String baseUrl = "https://reqres.in/api/users";
    //get headers
    @Test
    public void getHeaders() {
        given()
                .when()
                .get(baseUrl)
                .then()
                .statusCode(200)
                .log().headers();
    }

    //capture headers
    @Test
    public void captureHeaders() {
        String header = given()
                .when()
                .get(baseUrl)
                .then()
                .statusCode(200)
                .extract()
                .header("Content-Type");
//                .header("Server");
        System.out.println(header);
    }

    //get all headers
    @Test
    public void getAllHeaders() {
        Headers headers = given()
                .when()
                .get(baseUrl)
                .then()
                .statusCode(200)
                .extract()
                .headers();

//        System.out.println(headers);
        System.out.println(headers.getValues("Content-Type"));
//        System.out.println(headers.asList());
    }
}

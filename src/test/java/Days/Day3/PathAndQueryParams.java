package Days.Day3;

import org.testng.ITest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PathAndQueryParams {
    String baseUrl = "https://reqres.in/api/";
    //get a specific user
    @Test
    public void getASpecificUser() {
        int userId = 2;
        given()
                .baseUri(baseUrl)
                .pathParam("userId", userId)
                .when()
                .get("users/{userId}")
                .then()
                .statusCode(200)
                .log().body();
    }
    //using query params
    @Test
    public void getUsersWithQueryParams() {
        int page = 2;
        given()
                .baseUri(baseUrl)
                .queryParam("page", page)
//                .queryParam("id", 2)
                .when()
                .get("users")
                .then()
                .statusCode(200)
                .log().body();
    }
}

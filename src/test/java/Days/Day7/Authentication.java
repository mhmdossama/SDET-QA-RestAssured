package Days.Day7;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

public class Authentication {
    @Test
    public void testAuthentication() {
        System.out.println("Authentication test First is basic auth");
        given()
                .auth()
                .preemptive()
                .basic("admin", "admin")
                .when()
                .get("https://the-internet.herokuapp.com/basic_auth")
                .then()
                .statusCode(200)
//                .body("authenticated", equalTo(true))
                .log().body();
    }
    // Digest auth
    @Test
    public void testDigestAuthentication() {
        System.out.println("Authentication test Second is digest auth");
        given()
                .auth()
                .digest("admin", "admin")
                .when()
                .get("https://the-internet.herokuapp.com/basic_auth")
                .then()
                .statusCode(200)
                .body("authenticated", equalTo(true))
                .log().body();
    }

    // all types of auth using github collection
    @Test
    public void testGithubAuthentication() {
        System.out.println("Authentication test Third is github auth");
        given()
                .auth()
                .oauth2("ghp_4r7vX0x5g1q3j6f8e9d7a4b5c6d7e8f9g0h1")
                .when()
                .get("https://api.github.com/user")
                .then()
                .statusCode(200)
                .log().body();
    }
    // Bearer token auth
    @Test
    public void testBearerTokenAuthentication() {
        System.out.println("Authentication test Fourth is bearer token auth");
        given()
                .auth()
                .oauth2("ghp_4r7vX0x5g1q3j6f8e9d7a4b5c6d7e8f9g0h1")
                .when()
                .get("https://api.github.com/user")
                .then()
                .statusCode(200)
                .log().body();
    }
}

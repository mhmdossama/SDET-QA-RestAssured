package Days.Day3;

import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class CookiesDemo {

    @Test
    public void usingCookies() {

        given()
                .when()
                .get("https://www.google.com")
                .then()
                .statusCode(200)
                .log().headers();
    }

    // capture cookies
    @Test
    public void captureCookies() {
        String cookie = given()
                .when()
                .get("https://www.google.com")
                .then()
                .statusCode(200)
                .extract()
//                .cookie("AEC");
                .cookie("NID");
        System.out.println(cookie);
    }

    //get all cookies
    @Test
    public void getAllCookies() {
//        String cookie = given()
//                .when()
//                .get("https://www.google.com")
//                .then()
//                .statusCode(200)
//                .extract()
//                .cookies().toString();
//        System.out.println(cookie);

        Map <String, String> cookies = given()
                .when()
                .get("https://www.google.com")
                .then()
                .statusCode(200)
                .extract()
                .cookies();
        System.out.println(cookies);
        System.out.println(cookies.keySet());
        System.out.println(cookies.values());

    }

}

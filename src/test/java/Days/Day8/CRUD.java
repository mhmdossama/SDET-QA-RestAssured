package Days.Day8;

import com.github.javafaker.Faker;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CRUD {
    String userId;
    String baseUrl = "http://localhost:3000/users";
    String token = "mysecrettoken";
    @Test
    public void testCreation() {

        System.out.println("Creation test");
        // Add your test code here

        Faker faker = new Faker();
        String name = faker.name().fullName();
        String email = faker.internet().emailAddress();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", name);
        jsonObject.put("email", email);

        // Create a new user
        // Extract complete response
        String response = given()
                .header("Content-Type", "application/json")
                .baseUri(baseUrl)
                .auth().oauth2(token)
                .body(jsonObject.toString())
                .when()
                .post()
                .then()
                .statusCode(201)
                .extract()
                .asPrettyString();
        System.out.println("Response: " + response);
        // Extract userId from the response
        userId = response.substring(response.indexOf("id") + 4, response.indexOf(",") - 1);
        System.out.println("User ID: " + userId);
    }

    // Test Get user
    @Test
    public void getUser(){
        given().baseUri(baseUrl).pathParams("userId", userId)
                .auth().oauth2(token)
                .when().get()
                .then().log().body();
    }
    // Test Update user
    @Test
    public void updateUser(){
        Faker faker = new Faker();
        String name = faker.name().fullName();
        String email = faker.internet().emailAddress();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", name);
        jsonObject.put("email", email);

        // Update the user
        given()
                .header("Content-Type", "application/json")
                .baseUri(baseUrl)
                .pathParams("userId", userId)
                .auth().oauth2(token)
                .body(jsonObject.toString())
                .when()
                .put("/{userId}")
                .then()
                .statusCode(200)
                .log().body();

    }
    // Test Delete user
    @Test
    public void deleteUser(){

    }
}

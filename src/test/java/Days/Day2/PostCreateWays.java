package Days.Day2;


import org.json.JSONObject;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class PostCreateWays {
    String baseUrl = "https://reqres.in/api/";

    @Test
    public void testUsingHasMap(){
        HashMap  data = new HashMap();
        data.put("name", "alice");
        data.put("job", "engineer");
        given()
                .baseUri(baseUrl)
                .header("Content-Type", "application/json")
                .body(data)
                .when().post("users")
                .then().statusCode(201)
                .assertThat().body("name", equalTo("alice"),
                        "job", equalTo("engineer"),
                        "id", notNullValue(),
                        "createdAt", notNullValue()
                )
                .log().body();

    }


    //sending org.json
    @Test
    public void usingOrgJson (){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "eve");
        jsonObject.put("job", "web developer");

        given().baseUri(baseUrl)
                .contentType("application/json")
                .body(jsonObject.toString())
                .when().post("users")
                .then().log().body();
    }

    //sending using Pojo
    @Test
    public void usingPojo(){
        User user = new User();
        user.setName("robert");
        user.setJob("youtuber");

        given()
                .baseUri(baseUrl)
                .header("Content-Type", "application/json")
                .body(user)
                .when().post("users")
                .then().log().body();
    }


    //Sending using file
    @Test
    public void usingFile(){
        File user = new File("src/test/resources/user.json");
        given()
                .baseUri(baseUrl)
                .header("Content-Type", "application/json")
                .body(user)
                .when().post("users")
                .then().log().body();
    }


    //delete new created user
    @Test(priority = 2)
    public void deleteUser(){
        given()
                .baseUri(baseUrl)
                .header("Content-Type", "application/json")
                .when().delete("users/2")
                .then().statusCode(204)
                .log().all();
    }
    //insure user is deleted
    @Test(priority = 3)
    public void getUser(){
        given()
                .baseUri(baseUrl)
                .header("Content-Type", "application/json")
                .when().get("users/94")
                .then().statusCode(404)
                .assertThat().body("error", equalTo("Not Found"))
                .log().all();
    }
}

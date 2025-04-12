package Days.Day5;

import static io.restassured.RestAssured.given;

public class FileUploading {

    //test file upload
    //https://www.toolsqa.com/automation-practice-form/

    public void testFileUpload() {
        String filePath = "C:\\Users\\User\\Desktop\\test.txt";
        given()
                .multiPart("file", filePath).contentType("multipart/form-data")
                .when()
                .post("https://www.toolsqa.com/automation-practice-form/")
                .then()
                .statusCode(200)
                .log().all();
    }
}

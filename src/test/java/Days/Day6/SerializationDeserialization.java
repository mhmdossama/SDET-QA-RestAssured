package Days.Day6;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class SerializationDeserialization {

    public static class UserResponse {
        private Data data;
        private Support support;

        public Data getData() {
            return data;
        }

        public void setData(Data data) {
            this.data = data;
        }

        public Support getSupport() {
            return support;
        }

        public void setSupport(Support support) {
            this.support = support;
        }
    }

    public static class Data {
        private int id;
        private String email;
        private String first_name;
        private String last_name;
        private String avatar;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getFirst_name() {
            return first_name;
        }

        public void setFirst_name(String first_name) {
            this.first_name = first_name;
        }

        public String getLast_name() {
            return last_name;
        }

        public void setLast_name(String last_name) {
            this.last_name = last_name;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }
    }

    public static class Support {
        private String url;
        private String text;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }

    @Test
    public void testSerialization() {
        // Create a Data object
        Data data = new Data();
        data.setId(2);
        data.setEmail("janet.weaver@reqres.in");
        data.setFirst_name("Janet");
        data.setLast_name("Weaver");
        data.setAvatar("https://reqres.in/img/faces/2-image.jpg");

        // Create a Support object
        Support support = new Support();
        support.setUrl("https://contentcaddy.io?utm_source=reqres&utm_medium=json&utm_campaign=referral");
        support.setText("Tired of writing endless social media content? Let Content Caddy generate it for you.");

        // Create a UserResponse object
        UserResponse userResponse = new UserResponse();
        userResponse.setData(data);
        userResponse.setSupport(support);

        // Serialize the UserResponse object to JSON
        String json = given()
                .contentType("application/json")
                .body(userResponse)
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .extract()
                .asString();

        System.out.println("Serialized JSON: " + json);
    }

    @Test
    public void testDeserialization() {
        // Deserialize JSON to UserResponse object
        UserResponse response = given()
                .contentType("application/json")
                .when()
                .get("https://reqres.in/api/users/2")
                .then()
                .extract()
                .as(UserResponse.class);

        System.out.println("Deserialized User: " + response.getData().getFirst_name() + " " +
                response.getData().getLast_name() + ", Email: " + response.getData().getEmail());
    }
}
package RestPackage;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.Objects;

import static io.restassured.RestAssured.given;

public class PostResBin {

    String postFilePath = "src/json/post.json";

    public static Response send_res() {
        String requestBody = Objects.requireNonNull(Utils.readJson("post.json")).toString();
        RestAssured.baseURI = "https://reqres.in";


        Response response = (Response) given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBody)
                .when()
                .post("/api/users")
                .then()
                .extract();

        return (response);
    }
}

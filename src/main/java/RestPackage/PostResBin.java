package RestPackage;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.Objects;

import static io.restassured.RestAssured.given;

public class PostResBin {

    public static Response send_res() {
        String requestBody = Objects.requireNonNull(Utils.readJson("./src/json/post.json")).toString();
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";

        Response response = (Response) given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBody)
                .when()
                .post("/booking")
                .then()
                .extract();

        return (response);
    }
}

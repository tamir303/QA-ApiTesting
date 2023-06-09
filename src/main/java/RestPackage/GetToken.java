package RestPackage;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.Objects;

import static io.restassured.RestAssured.given;

public class GetToken {
    public static Response get_token() {
        String requestBody = Objects.requireNonNull(Utils.readJson("./src/json/token.json")).toString();
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";

        Response response = (Response) given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBody)
                .when()
                .post("/auth")
                .then()
                .extract();

        return (response);
    }
}

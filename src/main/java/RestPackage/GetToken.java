package RestPackage;

import io.restassured.response.Response;

import java.util.Objects;

import static io.restassured.RestAssured.given;

public class GetToken {
    public static Response get_token() {
        String requestBody = Objects.requireNonNull(Utils.readJson("./src/json/token.json")).toString();

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

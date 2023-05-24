package RestPackage;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.Objects;

import static io.restassured.RestAssured.given;

public class PutResBin {

    public static Response get_res(String id, String token, String requestBody) {
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
        Response response = (Response) given()
                .header("Content-Type", "application/json")
                .header("Cookie","token="+token)
                .and()
                .body(requestBody)
                .when()
                .put("/booking/" + id)
                .then()
                .extract();

        return (response);
    }
}

package RestPackage;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.Objects;

import static io.restassured.RestAssured.given;

public class DelResBin {
    public static Response del_obj(String id, String token) {
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
        Response response = (Response) given()
                .header("Cookie","token=" + token)
                .when()
                .delete("/booking/" + id)
                .then()
                .extract();

        return (response);
    }
}

package RestPackage;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GetResBin {

    public static Response send_res() {

        RestAssured.baseURI = "https://reqres.in";

        Response response = (Response) given()
                .header("Content-type", "application/json")
                .when()
                .get("/api/users/2")
                .then()
                .extract();


        return (response);
    }
}

package RestPackage;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PostResBin {

    public static Response send_res() {
        String requestBody = "{\n" +
                "  \"name\": \"formystudents\",\n" +
                "  \"job\": \"qaProffessional\"\n}";


        RestAssured.baseURI = "https://reqres.in";


        Response response = (Response) given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBody)
                .when()
                .post("/api/users")
                .then()
                .extract();

        //String s_repronse=response.toString();

        // System.out.println(s_repronse);

        return (response);
    }
}

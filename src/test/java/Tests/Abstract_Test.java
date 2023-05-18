package Tests;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;

public abstract class Abstract_Test {
    protected RequestSpecification request;

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://restful-booker.herokuapp.com/booking";
        request = RestAssured.given();
    }
}

package Tests;

import RestPackage.GetToken;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.text.ParseException;

public abstract class Abstract_Test {
    protected RequestSpecification request;
    protected String token;
    @Before
    public void setUp() {
        RestAssured.baseURI = "https://restful-booker.herokuapp.com/booking";
        request = RestAssured.given();
        token = GetToken.get_token().jsonPath().getString("token");
    }
}

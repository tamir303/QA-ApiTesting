import org.junit.BeforeClass;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public abstract class Abstract_Test {
    protected RequestSpecification request;

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
        request = RestAssured.given();
    }
}

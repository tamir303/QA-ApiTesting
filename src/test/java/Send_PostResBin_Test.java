import org.junit.Test;
import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;

import junit.framework.Assert;

import RestPackage.*;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Send_PostResBin_Test extends Abstract_Test {

    @Test
    public void createBookingTest() {
        String requestBody = "{\"firstname\":\"mymymy\",\"lastname\":\"Brown\",\"totalprice\":111,\"depositpaid\":true,\"bookingdates\":{\"checkin\":\"2018-01-01\",\"checkout\":\"2019-01-01\"},\"additionalneeds\":\"Breakfast\"}";

        request.header("Content-Type", "application/json");
        request.body(requestBody);

        Response response = request.post("/booking");
        int statusCode = response.getStatusCode();

        // Add assertions to validate the response
        // For example:
        // Assert.assertEquals(statusCode, 200);
    }

    public static void main(String args[]) {
        JUnitCore junit = new JUnitCore();
        junit.addListener(new TextListener(System.out));
        org.junit.runner.Result result = junit.run(Send_PostResBin_Test.class); // Replace "SampleTest" with the name of your class
        if (result.getFailureCount() > 0) {
            System.out.println("Test failed.");
            System.exit(1);
        } else {
            System.out.println("Test finished successfully.");
            System.exit(0);
        }
    }
}

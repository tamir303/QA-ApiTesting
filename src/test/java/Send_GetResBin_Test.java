import org.junit.Before;
import org.junit.BeforeClass;
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

public class Send_GetResBin_Test extends Abstract_Test {

    @Test
    public void updateBookingTest() {
        String requestBody = "{\"firstname\":\"Updated\",\"lastname\":\"Brown\",\"totalprice\":222,\"depositpaid\":false,\"bookingdates\":{\"checkin\":\"2019-01-01\",\"checkout\":\"2020-01-01\"},\"additionalneeds\":\"Lunch\"}";

        request.header("Content-Type", "application/json");
        request.header("Cookie", "token=YOUR_TOKEN_VALUE"); // Replace with the actual token

        request.body(requestBody);

        Response response = request.put("/booking/{bookingId}"); // Replace {bookingId} with the actual booking ID
        int statusCode = response.getStatusCode();

        // Add assertions to validate the response
        // For example:
        // Assert.assertEquals(statusCode, 200);
    }

    public static void main(String args[]) {
        JUnitCore junit = new JUnitCore();
        junit.addListener(new TextListener(System.out));
        org.junit.runner.Result result = junit.run(Send_GetResBin_Test.class); // Replace "SampleTest" with the name of your class
        if (result.getFailureCount() > 0) {
            System.out.println("Test failed.");
            System.exit(1);
        } else {
            System.out.println("Test finished successfully.");
            System.exit(0);
        }
    }
}

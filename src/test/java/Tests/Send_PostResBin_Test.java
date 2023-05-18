package Tests;

import org.junit.Test;
import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;

import RestPackage.*;

import io.restassured.response.Response;

public class Send_PostResBin_Test extends Abstract_Test {

    @Test
    public void createBookingTest() {
        Response response = PostResBin.send_res();
        String s_response = response.toString();
        System.err.println(s_response);
        System.err.println(response.getStatusCode()+" "+response.jsonPath().getString("id")+" "+response.jsonPath().getString("createdAt"));

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

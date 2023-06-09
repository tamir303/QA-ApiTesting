package Tests;

import RestPackage.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Before;
import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.ParseException;
import java.util.Objects;

public class Send_PutResBin_Test extends Abstract_Test {
    @Test
    public void updateBookingTest() {
        setUp();
        Response post, get;
        post = PostResBin.send_res();
        System.err.println("Post:\nHttp Status: " + post.getStatusCode()+"\n" +
                "Object Id: " + post.jsonPath().getString("bookingid")+" \n");

        String post_id = post.jsonPath().getString("bookingid");
        Assert.assertNotNull(get = GetWithQueryParams.send_get_params(post_id));
        System.err.println("Get:\nHttp Status: " + get.getStatusCode() +"\n");
        get.getBody().prettyPrint();

        String requestBody = Objects.requireNonNull(Utils.readJson("src/json/put.json")).toString();
        PutResBin.get_res(post_id, token, requestBody);
        Assert.assertNotNull(get = GetWithQueryParams.send_get_params(post_id));
        System.err.println("PUT:\nHttp Status: " + get.getStatusCode() +"\n");
        get.getBody().prettyPrint();
    }

    public static void main(String[] args) {
        JUnitCore junit = new JUnitCore();
        junit.addListener(new TextListener(System.out));
        org.junit.runner.Result result = junit.run(Send_PutResBin_Test.class); // Replace "SampleTest" with the name of your class
        if (result.getFailureCount() > 0) {
            System.out.println("Test failed.");
            System.exit(1);
        } else {
            System.out.println("Test finished successfully.");
            System.exit(0);
        }
    }
}

package Tests;

import RestPackage.GetWithQueryParams;
import RestPackage.PostResBin;
import RestPackage.PutResBin;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;
import org.testng.annotations.Test;

public class Send_PutResBin_Test extends Abstract_Test {

    @Test
    public void updateBookingTest() {
        Response post, get, put;
        post = PostResBin.send_res();

        System.err.println("Http Status: " + post.getStatusCode()+"\n" +
                "Object Id: " + post.jsonPath().getString("id")+" \n" +
                "TimeCreated:" + post.jsonPath().getString("createdAt"));

        String post_id = post.jsonPath().getString("id");
        Assert.assertNotNull(get = GetWithQueryParams.send_get_params(post_id));

        System.err.println("\nHttp Status: " + get.getStatusCode()+"\n" +
                "Object Id: " + get.jsonPath().getString("id")+" \n" +
                "TimeCreated:" + get.jsonPath().getString("createdAt"));
        //get.getBody().prettyPrint();

        PutResBin.get_res(post_id);
        //GetWithQueryParams.send_get_params(post_id).getBody().prettyPrint();
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

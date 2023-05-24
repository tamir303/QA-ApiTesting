package Tests;

import RestPackage.DelResBin;
import RestPackage.GetWithQueryParams;
import RestPackage.PostResBin;
import RestPackage.PutResBin;
import io.restassured.response.Response;
import org.apache.http.HttpRequest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;

public class Send_DeleteResBin_Test extends Abstract_Test {

    @Test
    public void deleteBookingTest() {
        Response post, get, delete;
        post = PostResBin.send_res();
        System.err.println("Post:\nHttp Status: " + post.getStatusCode() + "\n" +
                "Object Id: " + post.jsonPath().getString("bookingid") + " \n");

        String post_id = post.jsonPath().getString("bookingid");
        Assert.assertNotNull(get = GetWithQueryParams.send_get_params(post_id));
        System.err.println("Get:\nHttp Status: " + get.getStatusCode() + "\n");
        get.getBody().prettyPrint();

        delete = DelResBin.del_obj(post_id, token);
        Assert.assertEquals(delete.getStatusCode(), 201);

        get = GetWithQueryParams.send_get_params(post_id);
        Assert.assertEquals(get.getStatusCode(), 404);
        System.err.println("CHECK NOT EXIST: " + post_id);
        System.err.println(get.asPrettyString());
    }

    public static void main(String[] args) {
        JUnitCore junit = new JUnitCore();
        junit.addListener(new TextListener(System.out));
        org.junit.runner.Result result = junit.run(Send_DeleteResBin_Test.class); // Replace "SampleTest" with the name of your class
        if (result.getFailureCount() > 0) {
            System.out.println("Test failed.");
            System.exit(1);
        } else {
            System.out.println("Test finished successfully.");
            System.exit(0);
        }
    }
}

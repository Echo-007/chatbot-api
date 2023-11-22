package cn.bugstack.chatbot.api.test;

import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import javax.swing.text.html.parser.Entity;
import java.io.IOException;

public class ApiTest {
    @Test
    public void query_unanswered_question() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
//      188482452814222
        HttpGet get = new HttpGet("https://api.zsxq.com/v2/groups/188482452814222/topics?scope=unanswered_questions&count=20&end_time=2023-11-21T18:43:09.289+0800");

        get.addHeader("cookie", "abtest_env=product; zsxq_access_token=6098A126-D41B-1DB2-7970-96E26C138E77_7BA580FF758DDC15; zsxqsessionid=d2391c3ece08497c787e8711e6964c1d");
        get.addHeader("Content-Type", "application/json; charset=utf8");

        CloseableHttpResponse response = httpClient.execute(get);
        if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }
    @Test
    public void answer() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost("https://api.zsxq.com/v2/topics/188482455285252/answer");

        post.addHeader("cookie", "abtest_env=product; zsxq_access_token=6098A126-D41B-1DB2-7970-96E26C138E77_7BA580FF758DDC15; zsxqsessionid=d2391c3ece08497c787e8711e6964c1d");
        post.addHeader("Content-Type", "application/json; charset=utf8");

        String paramJson = "{\"req_data\":{\"text\":\"" +
                "我最爱的是云云" +
                "\\n7\",\"image_ids\":[],\"silenced\":true}}";

        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));
        post.setEntity(stringEntity);

        CloseableHttpResponse response = httpClient.execute(post);
        if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }

}




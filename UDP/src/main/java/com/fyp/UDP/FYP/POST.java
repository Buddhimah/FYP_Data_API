package com.fyp.UDP.FYP;

/**
 * Created by Buddhima on 11/14/2018.
 */
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class POST {
    public static void sendPost(String sentence) throws IOException {
        String dataarray[] = sentence.split(":");

        if(dataarray.length==2) {
            String id = dataarray[0];
            String data = dataarray[1];
            CloseableHttpClient client = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost("http://192.248.15.157:8081/meter/add");

            String json = "{\n" +
                    "\t\"id\":\"" +
                    id +
                    "\",\n" +
                    "\t\"data\": \"" +
                    data +
                    "\"\n" +
                    "}";
            StringEntity entity = new StringEntity(json);
            httpPost.setEntity(entity);
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-type", "application/json");

            CloseableHttpResponse response = client.execute(httpPost);
            System.out.println(response);

            client.close();
        }else{
            throw new IOException();
        }

    }
}
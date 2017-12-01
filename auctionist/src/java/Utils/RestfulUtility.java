/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Models.AuthenticationResponse;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.security.InvalidParameterException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;

/**
 *
 * @author fabri
 */
public class RestfulUtility {

    private String uri;

    void setSetUri(String uri) {
        this.uri = uri;
    }

    Object post(Object object, Class expectedReponse) throws UnsupportedEncodingException, IOException {
        Object responseObject;
        
        if (uri != null) {
            HttpClient client = HttpClientBuilder.create().build();
            HttpPost httpRequest = new HttpPost(uri);

            Gson toGson = new Gson();
            String jsonBody = toGson.toJson(object);

            StringEntity entity = new StringEntity(jsonBody);
            entity.setContentType(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
            httpRequest.setEntity(entity);

            httpRequest.addHeader("content-type", "application/json");
            HttpResponse httpResponse;
            httpResponse = client.execute((HttpUriRequest) httpRequest);

            BufferedReader rd = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
            String line;
            String json = "";
            while ((line = rd.readLine()) != null) {
                json += line;
            }

            Gson gson = new Gson();
            responseObject = gson.fromJson(json, expectedReponse);

        } else {
            throw new InvalidParameterException("Parâmetro Uri não pode ser nulo");
        }

        return responseObject;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Models.AuthenticationResponse;
import Models.BaseObject;
import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
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

    public static Object post(String uri, Object object, Class expectedReponse) throws UnsupportedEncodingException, IOException {

        return post("", uri, object, expectedReponse);
    }

    public static Object post(String auth, String uri, Object object, Class expectedReponse) throws UnsupportedEncodingException, IOException {
        Object responseObject = null;

        if (uri != null) {
            HttpClient client = HttpClientBuilder.create().build();
            HttpPost httpRequest = new HttpPost(uri + auth);

            Gson toGson = new Gson();
            String jsonBody = toGson.toJson(object);

            StringEntity entity = new StringEntity(jsonBody);
            entity.setContentType(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
            httpRequest.setEntity(entity);

            httpRequest.addHeader("content-type", "application/json");
            HttpResponse httpResponse;
            httpResponse = client.execute((HttpUriRequest) httpRequest);

            if (httpResponse.getStatusLine().getStatusCode() == 200) {
                BufferedReader rd = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
                String line;
                String json = "";
                while ((line = rd.readLine()) != null) {
                    json += line;
                }

                if (json != null) {

                    Gson gson = new Gson();
                    responseObject = gson.fromJson(json, expectedReponse);
                }
            }

        } else {
            throw new InvalidParameterException("Parâmetro Uri não pode ser nulo");
        }

        return responseObject;
    }

    public static Object put(String auth, String uri, Object object, Class expectedReponse) throws UnsupportedEncodingException, IOException {
        Object responseObject = null;

        if (uri != null) {
            HttpClient client = HttpClientBuilder.create().build();
            HttpPut httpRequest = new HttpPut(uri + auth);

            Gson toGson = new Gson();
            String jsonBody = toGson.toJson(object);

            StringEntity entity = new StringEntity(jsonBody);
            entity.setContentType(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
            httpRequest.setEntity(entity);

            httpRequest.addHeader("content-type", "application/json");
            HttpResponse httpResponse;
            httpResponse = client.execute((HttpUriRequest) httpRequest);
            if (httpResponse.getStatusLine().getStatusCode() == 200) {
                BufferedReader rd = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
                String line;
                String json = "";
                while ((line = rd.readLine()) != null) {
                    json += line;
                }

                if (json != null) {

                    Gson gson = new Gson();
                    responseObject = gson.fromJson(json, expectedReponse);
                }
            }

        } else {
            throw new InvalidParameterException("Parâmetro Uri não pode ser nulo");
        }

        return responseObject;
    }

    public static boolean delete(String auth, String uri) throws UnsupportedEncodingException, IOException {
        boolean responseObject = false;

        if (uri != null) {
            HttpClient client = HttpClientBuilder.create().build();
            HttpDelete httpRequest = new HttpDelete(uri + auth);

            httpRequest.addHeader("content-type", "application/json");
            HttpResponse httpResponse;
            httpResponse = client.execute((HttpUriRequest) httpRequest);
            if (httpResponse.getStatusLine().getStatusCode() == 200) {
                return true;
            } else {
                return false;
            }

        } else {
            throw new InvalidParameterException("Parâmetro Uri não pode ser nulo");
        }

       
    }

    public static Object get(String auth, String uri, Class expectedReponse) throws IOException {
        Object responseObject = null;

        if (uri != null) {
            HttpClient client = HttpClientBuilder.create().build();
            HttpGet httpRequest = new HttpGet(uri + auth);

            httpRequest.addHeader("content-type", "application/json");
            HttpResponse httpResponse;
            httpResponse = client.execute((HttpUriRequest) httpRequest);

            if (httpResponse.getStatusLine().getStatusCode() == 200) {
                BufferedReader rd = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
                String line;
                String json = "";
                while ((line = rd.readLine()) != null) {
                    json += line;
                }

                if (json != null) {

                    Gson gson = new Gson();
                    responseObject = gson.fromJson(json, Object.class);

                    if (responseObject != null) {

                        List<Object> items = new ArrayList();
                        if (responseObject instanceof LinkedTreeMap) {
                            LinkedTreeMap linkedTreeMap = (LinkedTreeMap) responseObject;
                            for (Object o : linkedTreeMap.entrySet()) {

                                if (o != null) {
                                    String key = ((Entry) o).getKey().toString();
                                    Object i = linkedTreeMap.get(key);

                                    String newJson = gson.toJson(i);
                                    Object newObj = gson.fromJson(newJson, expectedReponse);

                                    if (newObj instanceof BaseObject) {
                                        ((BaseObject) newObj).setKey(key);
                                    }

                                    items.add(newObj);
                                }
                            }
                        }

                        if (items.size() > 0) {
                            responseObject = items;
                        }
                    }

                }

            }

        } else {
            throw new InvalidParameterException("Parâmetro Uri não pode ser nulo");
        }

        return responseObject;
    }

}

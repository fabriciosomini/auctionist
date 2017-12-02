/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Models.AuthenticationRequest;
import Models.AuthenticationResponse;
import Repository.BidderSingleton;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import javax.security.sasl.AuthenticationException;
import org.apache.http.HttpResponse;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;

/**
 *
 * @author fabri
 */
public class AuthenticationUtility {

    private final static String AUTH_URI
            = "https://www.googleapis.com/identitytoolkit/v3/relyingparty/"
            + "verifyPassword?key=AIzaSyAopOOxFjt-irkt4o3ZIZGi9IM9eJ8710Q";

    public static AuthenticationResponse Authenticate(String email, String password) throws UnsupportedEncodingException, IOException {

        CredentialsProvider credentialsProvider = new BasicCredentialsProvider();

        AuthenticationRequest authenticationRequest = new AuthenticationRequest();
        authenticationRequest.setEmail(email);
        authenticationRequest.setPassword(password);
        authenticationRequest.setReturnSecureToken(true);

        AuthenticationResponse authenticationResponse
                = (AuthenticationResponse) RestfulUtility.post(
                        AUTH_URI,
                        authenticationRequest, 
                        AuthenticationResponse.class);

        return authenticationResponse;
    }
    
    public static boolean IsAuthenticated() throws IOException{
    
          String itemUrl = "https://auctionist-f4888.firebaseio.com/Auth.json?auth=";
     
        
          try{
           RestfulUtility.get(
                        BidderSingleton.Get().getBidder().getAuthToken(),
                        itemUrl,
                        Object.class);
          }catch(AuthenticationException ex){
              
              return false;
          }
       
        
       return true;
    }
}

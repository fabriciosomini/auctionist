/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author fabri
 */
public class Bidder extends BaseObject{
    private String name;
    private String authToken;
    private String userId;

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String id) {
        this.authToken = id;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}

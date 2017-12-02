/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

public class Bid extends BaseObject {
 
    private Bidder bidder;
    private String id;
    private float bidAmount;
    
    public Bidder getBidder() {
        return bidder;
    }
    public void setBidder(Bidder bidder) {
        this.bidder = bidder;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

   

    public float getBidAmount() {
        return bidAmount;
    }

    public void setBidAmount(float bidAmount) {
        this.bidAmount = bidAmount;
    }
    
}

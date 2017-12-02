/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import Models.Bidder;

/**
 *
 * @author fabri
 */
public class BidderSingleton {
     private static final BidderSingleton BIDDER_SINGLETON = new BidderSingleton();
     public static BidderSingleton Get() {
         return BIDDER_SINGLETON;
     }
    private Bidder bidder;

    public Bidder getBidder() {
        return bidder;
    }

    public void setBidder(Bidder bidder) {
        this.bidder = bidder;
    }
    
  
    
    
}

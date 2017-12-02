/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import Models.Bid;
import Utils.RestfulUtility;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fabri
 */
public class BidRepository {

    private String bidUrl = "";
    private static final BidRepository bidRepository = new BidRepository();

    public static BidRepository Get() {
        return bidRepository;
    }

    public Bid GetBid(String auth, int id) {

        return null;
    }

    public List<Bid> GetBidList(String auth) {
        List<Bid> bidList = new ArrayList<>();

        return bidList;
    }

    public List<Bid> Search(String auth, String type, String name) {
        List<Bid> bidList;

        bidList = GetBidList(auth);
        return bidList;
    }

    public int DeleteBid(String auth, int id) {
        
        return 0;
    }

    public Bid Save(String auth, Bid bid) throws IOException {
        if (bid.getId() != null) {
            return InsertBid(auth, bid);
        } else {
            return UpdateBid(auth, bid);
        }
    }

    private Bid InsertBid(String auth, Bid bid) throws IOException {

        return (Bid) RestfulUtility.post(bidUrl, bid, Bid.class);

    }

    private Bid UpdateBid(String auth, Bid bid) throws IOException {
        return (Bid) RestfulUtility.put(auth, bidUrl, bid, Bid.class);
    }
}

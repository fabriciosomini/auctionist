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

    public Bid GetBid(int id) {

        return null;
    }

    public List<Bid> GetBidList(String selector) {
        List<Bid> bidList = new ArrayList<>();

        return bidList;
    }

    public List<Bid> Search(String type, String name) {
        List<Bid> bidList;

        bidList = GetBidList("");
        return bidList;
    }

    public int DeleteBid(int id) {
        
        return 0;
    }

    public Bid Save(Bid bid) throws IOException {
        if (bid.getId() != null) {
            return InsertBid(bid);
        } else {
            return UpdateBid(bid);
        }
    }

    private Bid InsertBid(Bid bid) throws IOException {

        return (Bid) RestfulUtility.post(bidUrl, bid, Bid.class);

    }

    private Bid UpdateBid(Bid bid) throws IOException {
        return (Bid) RestfulUtility.put(bidUrl, bid, Bid.class);
    }
}

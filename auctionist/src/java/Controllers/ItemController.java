/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Bid;
import Models.Bidder;
import Models.Item;
import Repository.ItemRepository;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fabri
 */
@WebServlet(urlPatterns = {"/save-item", "/create-item", "/delete-item", "/list-item", "/item-bid-list"})
public class ItemController extends HttpServlet {

 
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String auth = (String)request.getSession().getAttribute("IDTOKEN");
        String routePath = request.getServletPath();
        if (routePath.endsWith("/list-item")) {
            request.setAttribute("itemCollection", ItemRepository.Get().GetItemList(auth));
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } else if (routePath.endsWith("/item-bid-list")) {
            String id = (String)request.getParameter("id");
            
            
            request.setAttribute("currentItem", ItemRepository.Get().GetItem(auth, id));
            request.getRequestDispatcher("/item-bid-list.jsp").forward(request, response);
        }
    }

    /* private List<Item> generateData() {

        float initialBid = (float) Math.random();
        List<Item> items = new ArrayList();
        for (int itemIndex = 0; itemIndex < 50; itemIndex++) {

            List<Bid> bids = new ArrayList();
            for (int i = 0; i < 120; i++) {
                Bidder bidder = new Bidder();
                bidder.setId(String.valueOf(i));
                bidder.setName("Leiloante " + Math.random());
                Bid bid = new Bid();
                bid.setBidAmount(initialBid);
                bid.setBidder(bidder);
                bids.add(bid);

                initialBid += 150;

            }
            Item item = new Item();
            item.setId(String.valueOf(Math.random()).replace(".", ""));
            item.setDescription("Item " + String.valueOf(Math.random()));
            item.setInitialAmount(initialBid);
            bids.stream().forEach(p -> item.addBid(p));
            items.add(item);

        }

        return items;

    }*/

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

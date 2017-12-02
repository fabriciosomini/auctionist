/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Bid;
import Models.Bidder;
import Models.Item;
import Repository.BidderSingleton;
import Repository.ItemRepository;
import Utils.RestfulUtility;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fabri
 */
@WebServlet(urlPatterns = {
    "/save-item",
    "/create-item",
    "/delete-item",
    "/list-item",
    "/list-bids",
    "/add-bid"
})
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

        String auth = (String) request.getSession().getAttribute("IDTOKEN");
        String routePath = request.getServletPath();
        if (routePath.endsWith("/list-item")) {

            List<Item> items = ItemRepository.Get().GetItemList(auth);
  
            request.setAttribute("itemCollection", items);
            request.getRequestDispatcher("/index.jsp").forward(request, response);

        } else if (routePath.contains("/list-bids")) {

            String id = (String) request.getParameter("id");
            Item item = ItemRepository.Get().GetItem(auth, id);
            Collections.reverse(item.getBids());
           
            request.setAttribute("currentItem", item);
            if (item.getOwnerId().equals(BidderSingleton.Get().getBidder().getToken())) {
                request.setAttribute("isOwner", true);
            } else {
                request.setAttribute("isOwner", false);
            }
            request.getRequestDispatcher("/item-bid-list.jsp").forward(request, response);

        } else if (routePath.endsWith("/create-item")) {
            request.getRequestDispatcher("/create-item.jsp").forward(request, response);
        } else if (routePath.contains("/delete-item")) {
            String id = (String) request.getParameter("id");
            Item item = ItemRepository.Get().GetItem(auth, id);
            ItemRepository.Get().DeleteItem(auth, item.getKey());
            response.sendRedirect("list-item");
        }

    }

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

        String routePath = request.getServletPath();
        String auth = (String) request.getSession().getAttribute("IDTOKEN");

        if (routePath.endsWith("/save-item")) {

            String id = UUID.randomUUID().toString();
            String name = request.getParameter("itemName");
            String description = request.getParameter("itemDescription");
            float initialAmount = Float.valueOf(request.getParameter("itemPrice"));

            Item item = new Item();
            item.setId(id);
            item.setName(name);
            item.setDescription(description);
            item.setInitialAmount(initialAmount);
            item.setOwnerId(BidderSingleton.Get().getBidder().getToken());

            ItemRepository.Get().Save(auth, item);

            response.sendRedirect("list-item");
        } else if (routePath.contains("/add-bid")) {

            String id = (String) request.getParameter("id");
            Item item = ItemRepository.Get().GetItem(auth, id);
            float bidAmount = Float.valueOf(request.getParameter("txtBidValue"));

            if (bidAmount <= item.getHighestBid()) {
                request.getSession().setAttribute("bidResult",
                        "Seu lance deve ser maior que: R$ " + item.getHighestBid());
            } else {

                request.getSession().setAttribute("bidResult", null);
                String description = request.getParameter("itemDescription");

                Bid bid = new Bid();
                bid.setBidder(BidderSingleton.Get().getBidder());
                bid.setBidAmount(0);
                bid.setBidAmount(bidAmount);

                item.addBid(bid);

                ItemRepository.Get().UpdateItem(auth, item);
            }

            response.sendRedirect("list-bids?id=" + id);

        }
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

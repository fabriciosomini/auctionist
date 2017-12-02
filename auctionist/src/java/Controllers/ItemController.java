/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Item;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(urlPatterns = {"/save-item", "/create-item", "/delete-item", "/list-item" })
public class ItemController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String routePath = request.getServletPath();

        if (routePath.endsWith("/list-item")) {
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } else if (routePath.endsWith("/create-item")) {
            request.getRequestDispatcher("/create-item.jsp").forward(request, response);
        }
    }

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
          
        Item item1 = new Item();
        item1.setDescription("CARRO VELHO");
        item1.setId("1");
        item1.setInitialAmount(2500);
        
          Item item2 = new Item();
        item2.setDescription("CASA CAINDO AOS PEDAÇOS");
        item2.setId("1");
        item2.setInitialAmount(7570);
        
          Item item3 = new Item();
        item3.setDescription("ROUPA USADA");
        item3.setId("1");
        item3.setInitialAmount(425);
        
          Item item4 = new Item();
        item4.setDescription("FILHOS SUJOS");
        item4.setId("1");
        item4.setInitialAmount(100);
        
          Item item5 = new Item();
        item5.setDescription("MARIDO BROXA");
        item5.setId("1");
        item5.setInitialAmount(12);
        
        List<Item> itemList = new  ArrayList();
        itemList.add(item1);
        itemList.add(item2);
        itemList.add(item3);
        itemList.add(item4);
        itemList.add(item5);
        //request.setAttribute("itemCollection", ItemRepository.Get().GetItemList(""));
        request.setAttribute("itemCollection", itemList);
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
        processRequest(request, response);
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

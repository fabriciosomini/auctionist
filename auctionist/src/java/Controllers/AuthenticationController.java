/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.AuthenticationResponse;
import Models.Bidder;
import Repository.BidderSingleton;
import Utils.AuthenticationUtility;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fabri
 */
@WebServlet(urlPatterns = {"/signin-submit", "/login"})
public class AuthenticationController extends HttpServlet {

  

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
        
        
        request.getRequestDispatcher("/login.jsp").forward(request, response);
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

        if (routePath.endsWith("/signin-submit")) {

            String username = (String) request.getParameter("txtLogin");
            String password = (String) request.getParameter("txtPass");

            if (username != null && password != null) {
                AuthenticationResponse authentication
                        = AuthenticationUtility.Authenticate(username, password);

                if (authentication != null) {
                    if (authentication.isRegistered()) {

                        request.getSession().setAttribute("IDTOKEN", authentication.getIdToken());
                        request.getSession().setAttribute("signInResult", null);
                        
                        Bidder bidder = new Bidder();
                        bidder.setId(authentication.getLocalId());
                        bidder.setName(authentication.getEmail());
                        bidder.setToken(authentication.getIdToken());
                        
                        BidderSingleton.Get().setBidder(bidder);
                        response.sendRedirect("list-item");
                        
                        

                    } else {
                        
                        request.getSession().setAttribute("signInResult", "Usuário ou senha incorretos");
                        response.sendRedirect("login");
                    }
                }

            }

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

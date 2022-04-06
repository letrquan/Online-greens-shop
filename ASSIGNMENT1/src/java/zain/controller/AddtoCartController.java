/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zain.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import zain.products.ProductCart;
import zain.products.ProductDTO;
import zain.products.ProductDao;
import zain.shopping.Cart;

/**
 *
 * @author quan2
 */
@WebServlet(name = "AddtoCartController", urlPatterns = {"/AddtoCartController"})
public class AddtoCartController extends HttpServlet {

    private static final String ERROR = "shopping.jsp";
    private static final String SUCCESS = "shopping.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            HttpSession session = request.getSession();
            if (session.getAttribute("LOGIN_USER") != null) {
                String productID = request.getParameter("product");
                int quantity = Integer.parseInt(request.getParameter("quantity"));
                ProductDao dao = new ProductDao();
                ProductDTO product = dao.getProductbyID(productID);
                ProductCart procart = new ProductCart(product.getProductID(), product.getProductName(), product.getDescription(), dao.getCategoryNamebyID(product.getCategoryID()), product.getMarketPrice(), quantity, product.getImage());
                Cart cart = (Cart) session.getAttribute("CART");
                if (cart == null) {
                    cart = new Cart();
                    session.setAttribute("PAY", null);
                }
                if(cart.add(product, procart)==true){
                session.setAttribute("CART", cart);
                url = SUCCESS;
                }else{
                    session.setAttribute("ERROR_MESSAGE", "ADD FAIL");
                }
            }
        } catch (Exception e) {
            log("Error at AddtoCartController" + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
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
        processRequest(request, response);
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

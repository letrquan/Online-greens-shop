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
import zain.products.ProductDao;
import zain.shopping.Cart;
import zain.shopping.OrderError;
import zain.shopping.Orders;

/**
 *
 * @author quan2
 */
@WebServlet(name = "PayController", urlPatterns = {"/PayController"})
public class PayController extends HttpServlet {

    private static final String ERROR = "pay.jsp";
    private static final String ORDER_DETAIL = "OrderDetailController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        OrderError ordererror = new OrderError();
        try {
            boolean check = true;
            ProductDao dao = new ProductDao();
            String userID = request.getParameter("userID");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            String address = request.getParameter("address");
            String total = request.getParameter("total");
            String statusID = request.getParameter("statusID");
            String paymentStatus = "paid";
            if (phone.length() > 13 || phone.length() < 2 || phone.matches("(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%!])")) {
                ordererror.setPhoneerror("Phone [2,13] and Number only !");
                check = false;
            }
            if (address.length() > 300 || address.length() < 2) {
                ordererror.setAddresserror("Address [2,300]");
                check = false;
            }
            if (check == true) {
                Orders order = new Orders("", email, userID, address, phone, total, "", statusID, paymentStatus);
                boolean checkOrder = dao.writeOrder(order);
                if (checkOrder == true) {
                    url = ORDER_DETAIL;
                }
            }else{
                request.setAttribute("ORDER_ERROR", ordererror);
            }
        } catch (Exception e) {
            log("ERROR at PayController: " + e.toString());
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

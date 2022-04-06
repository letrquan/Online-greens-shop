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
import zain.users.UserDTO;
import zain.users.UserDao;
import zain.users.UserError;

/**
 *
 * @author quan2
 */
@WebServlet(name = "CreateController", urlPatterns = {"/CreateController"})
public class CreateController extends HttpServlet {
    
    private static final String ERROR = "createUser.jsp";
    private static final String SUCCESS = "shopping.jsp";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        UserError userError = new UserError();
        try {
            UserDao dao = new UserDao();
            String userID = request.getParameter("userID");
            String fullName = request.getParameter("fullName");
            String roleID = request.getParameter("roleID");
            String password = request.getParameter("psw");
            String confirmPassword = request.getParameter("psw-repeat");
            String phone = request.getParameter("phone");
            String address = request.getParameter("address");
            String statusID = request.getParameter("statusID");
            String createDate = request.getParameter("createDate");
            boolean check = true;
            if (userID.length() < 2 || userID.length() > 50) {
                userError.setUserIDerror("User ID [2,10] ");
                check = false;
            } else {
                if (dao.checkDuplicate(userID)) {
                    userError.setUserIDerror("User ID Duplicate !");
                    check = false;
                }
            }
            if (fullName.length() > 50 || fullName.length() < 2) {
                userError.setFullNameerror("Full Name [2,50] !");
                check = false;
            }
            if (phone.length() > 13 || phone.length() < 2 || phone.matches("(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%!])")) {
                userError.setPhoneerror("Phone [2,13] and Number only !");
                check = false;
            }
            if (address.length() > 300 || address.length() < 2) {
                userError.setAddresserror("Address [2,300]");
                check = false;
            }
            if (!password.equals(confirmPassword)) {
                userError.setConfirmpassworderror("Confirm Password not correct!");
                check = false;
            }
            if (check) {
                UserDTO user = new UserDTO(userID, fullName, password, roleID, phone, address, statusID, createDate);
                boolean checkUpdate = dao.insertUserNew(user);
                if (checkUpdate) {
                    url = SUCCESS;
                }
            } else {
                request.setAttribute("USER_ERROR", userError);
            }
        } catch (Exception e) {
            log("ERROR AT CREATECONTROLLER: " + e.toString());
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

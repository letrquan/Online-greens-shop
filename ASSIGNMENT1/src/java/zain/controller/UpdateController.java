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
@WebServlet(name = "UpdateController", urlPatterns = {"/UpdateController"})
public class UpdateController extends HttpServlet {

    private static final String ERROR = "update.jsp";
    private static final String SUCCESS = "SearchUserController";
    private static final String LOGIN = "shopping.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String userID = request.getParameter("userID");
            String fullName = request.getParameter("fullName");
            String roleID = request.getParameter("roleID").trim();
            String phone = request.getParameter("phone").trim();
            String password = request.getParameter("psw");
            String confirmPassword = request.getParameter("psw-repeat");

            String address = request.getParameter("address");
            boolean check = true;
            UserError error = new UserError();
            if (fullName.length() > 50 || fullName.length() < 1) {
                error.setFullNameerror("Full Name [2,50] !");
                check = false;
            }
            if (roleID.length() != 1 || (!roleID.equals("1") && !roleID.equals("2"))) {
                error.setRoleIDerror("Wrong Role ID!");
                check = false;
            }
            if (phone.length() > 13 || phone.length() < 2 && phone.matches("(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%!])")) {
                error.setPhoneerror("Phone [2,13] and Number only !");
                check = false;
            }
            if (password == null) {
                password = "";
            } else {
                if (!password.equals(confirmPassword)) {
                    error.setConfirmpassworderror("Confirm Password not correct!");
                    check = false;
                }
            }
            if (check) {
                UserDao dao = new UserDao();
                boolean checkUpdate=false;
                if(password.isEmpty()){
                    checkUpdate=dao.updateUserAdmin(new UserDTO(userID, fullName, "", roleID, phone, address, "", ""));
                }else{
                UserDTO user = new UserDTO(userID, fullName, password, roleID, phone, address,"", "");
                checkUpdate = dao.updateUser(user);
                }
                if (checkUpdate) {
                    HttpSession session = request.getSession();
                    UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");
                    boolean check1 = (userID.trim()).equals(loginUser.getUserID());
                    if (check1) {
                        loginUser.setFullName(fullName);
                        loginUser.setRoleID(roleID);
                        loginUser.setPhone(phone);
                        loginUser.setAddress(address);
                        session.setAttribute("LOGIN_USER", loginUser);
                    }
                    if ((loginUser.getRoleID().trim()).equals("1")) {
                        url = SUCCESS;
                    } else {
                        url = LOGIN;
                    }
                }
            } else {
                request.setAttribute("USER_ERROR", error);
            }
        } catch (Exception e) {
            log("ERROR at UpdateController" + e.toString());
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

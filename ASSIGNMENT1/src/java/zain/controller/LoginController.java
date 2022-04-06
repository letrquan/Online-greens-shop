/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zain.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import zain.users.UserDao;
import zain.users.UserDTO;

/**
 *
 * @author quan2
 */
public class LoginController extends HttpServlet {

    private static final String ERROR="error.jsp";
    private static final String ADMIN_PAGE="admin1.jsp";
    private static final String US_PAGE="shopping.jsp";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url=ERROR;
        try {
            String userID=request.getParameter("uname");
            String password=request.getParameter("psw");
            UserDao a=new UserDao();
            UserDTO user=a.checkLogin(userID, password);
            HttpSession session=request.getSession();
            if(user==null){
                session.setAttribute("ERROR_MESSAGE", "Wrong ID or password!");
            }else{
                String statusID= user.getStatusID().trim();
                if(statusID.equals("1")){
                String roleID=user.getRoleID().trim();
                session.setAttribute("LOGIN_USER", user);
                if("1".equals(roleID)){
                    url=ADMIN_PAGE;
                }else if("2".equals(roleID)){
                    url=US_PAGE;
                }else{
                    session.setAttribute("ERROR_MESSAGE", "Your role is not supported!");
                }
                }else{
                    session.setAttribute("ERROR_MESSAGE", "Your account no longer exist!");
                }
            }
        } catch (Exception e) {
            log("ERROR at LoginController: "+e.toString());
        }finally{
            response.sendRedirect(url);
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

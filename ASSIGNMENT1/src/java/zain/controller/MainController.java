package zain.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author quan2
 */
public class MainController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String LOGIN = "LoginController";
    private static final String SEARCH_USER = "SearchUserController";
    private static final String LOGOUT = "LogoutController";
    private static final String DELETE = "DeleteController";
    private static final String UPDATE_PAGE = "update.jsp";
    private static final String CONFIRM_UPDATE = "UpdateController";
    private static final String CREATE = "CreateController";
    private static final String ADD_TO_CART = "AddtoCartController";
    private static final String VIEW_CART = "viewcart.jsp";
    private static final String REMOVE = "RemoveController";
    private static final String EDIT_CART = "EditCartController";
     private static final String SEARCH_PRODUCT = "SearchProductController";
     private static final String DETAIL = "ProductDetailController";
     private static final String PAY = "pay.jsp";
     private static final String PAYMENT = "PayController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String action = request.getParameter("action");
            if ("Login".equals(action)) {
                url = LOGIN;
            } else if ("Search".equals(action)) {
                url = SEARCH_USER;
            } else if ("LogOut".equals(action)) {
                url = LOGOUT;
            } else if("Delete".equals(action)){
                url=DELETE;
            }else if("Update".equals(action)){
                url=UPDATE_PAGE;
            }else if("Confirm Update".equals(action)){
                url=CONFIRM_UPDATE;
            }else if("Create".equals(action)){
                url=CREATE;
            }else if("add".equals(action)){
                url=ADD_TO_CART;
            }else if("view".equals(action)){
                url=VIEW_CART;
            }else if("Remove".equals(action)){
                url=REMOVE;
            }else if("Edit".equals(action)){
                url=EDIT_CART;
            }else if("product".equals(action)){
                url=SEARCH_PRODUCT;
            }else if("detail".equals(action)){
                url=DETAIL;
            }else if("Pay".equals(action)){
                url=PAY;
            }else if("Payment".equals(action)){
                url=PAYMENT;
            }else{
                HttpSession session = request.getSession();
                session.setAttribute("ERROR_MESSAGE", "Function is not supported!");
            }
        } catch (Exception e) {
            log("ERROR at MainController: " + e.toString());
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

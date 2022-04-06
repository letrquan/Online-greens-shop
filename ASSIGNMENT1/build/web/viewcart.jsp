<%-- 
    Document   : viewcart
    Created on : Jun 17, 2021, 3:34:58 PM
    Author     : quan2
--%>

<%@page import="zain.products.ProductDao"%>
<%@page import="zain.products.ProductCart"%>
<%@page import="zain.shopping.Cart"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" media="all" href="CSS/viewcart.css">
        <link rel="shortcut icon" href="CSS/1879.ico">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart Information</title>
    </head>
    <body style="font-family: 'Quicksand', sans-serif; color: whitesmoke">
        <c:if test="${sessionScope.LOGIN_USER == null}">
            <c:redirect url="shopping.jsp"></c:redirect>
        </c:if>
        <%
            String pay_message = (String) session.getAttribute("PAY");
            Cart cart = (Cart) session.getAttribute("CART");
            if (cart == null && pay_message != null) {
        %>
        <h1><%= pay_message%></h1>
        <%
        } else {
            if (cart == null && pay_message == null) {
        %>
        <h1>Your Cart Is Blank</h1>
        <%
            }else{
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>No</th>
                    <th>Image</th>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Quantity</th>
                    <th>Price</th>
                    <th>Total</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int count = 1;
                    double total = 0;
                    for (ProductCart pro : cart.getCart().values()) {
                        total += (pro.getMarketPrice()) * (pro.getQuantityCart());
                %>
            <form action="MainController">

                <tr>
                    <td><%= count++%></td>
                    <td><img src="<%= pro.getImage()%>" alt="<%= pro.getProductName()%>" width="120" height="150"></td>
                    <td><input type="text" name="id" value="<%= pro.getProductID()%>" readonly/></td>
                    <td><%= pro.getProductName()%></td>
                    <td><input type="number" name="quantity" value="<%= pro.getQuantityCart()%>" required min="1" /></td>
                    <td><%= pro.getMarketPrice()%></td>
                    <td><%= pro.getMarketPrice() * pro.getQuantityCart()%></td>
                    <td>
                        <input type="submit" name="action" value="Remove"/>
                    </td>
                    <td>
                        <input type="submit" name="action" value="Edit"/>
                    </td>
                </tr>
            </form>
            <%
                }
            %>
        </tbody>
    </table>
    <h1>Total: <%= total%> VND</h1>
    <%
        if(!cart.getCart().isEmpty()){
        %>
    <form action="MainController">
        <input type="hidden" value="<%= total %>" name="total"/>
        <button type="submit" name="action" value="Pay">Process to checkout</button>
    </form>
        <%
            }
    %>
    <%
        }
            }
    %>
    <button style="display: inline-block;">
        <a href="shopping.jsp" style="text-decoration: none; color: whitesmoke;">Add more</a>
    </button>
</body>
</html>

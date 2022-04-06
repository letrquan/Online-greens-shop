<%-- 
    Document   : pay
    Created on : Jul 9, 2021, 4:09:18 PM
    Author     : quan2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" media="all" href="CSS/createUser.css">
        <link rel="shortcut icon" href="CSS/1879.ico">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PAYMENT</title>
    </head>
    <body>
        <c:if test="${sessionScope.LOGIN_USER == null}">
            <c:redirect url="shopping.jsp"></c:redirect>
        </c:if>
        <%
            String total = request.getParameter("total");
        %>
        <form action="MainController" method="POST">
            <div class="container">
                <h1>Payment</h1>
                <p>Please fill in this form to pay for product</p>
                <hr>

                <label for="id"><b>User ID</b></label>
                <input type="text" value="${sessionScope.LOGIN_USER.getUserID()}" name="userID" id="id" readonly></br>

                <label for="email"><b>Email</b></label>
                <input type="email" placeholder="Enter Email" name="email" id="email" ></br>

                <label for="phone"><b>Phone</b></label>
                <input type="text" placeholder="Enter Phone" name="phone" id="phone" ></br>
                ${requestScope.ORDER_ERROR.getPhoneerror()}</br>

                <label for="address"><b>Address</b></label>
                <input type="text" placeholder="Enter Address" name="address" id="address" ></br>
                ${requestScope.ORDER_ERROR.getAddresserror()}</br>

                <label for="total"><b>Total Money</b></label>
                <input type="text" value="<%= total %>" name="total" id="total" ></br>

                <hr>
                <input type="hidden" name="statusID" value="1"/>
                <hr>
                <button type="submit" class="registerbtn" name="action" value="Payment" onclick="funtion()">Payment</button>

            </div>
        </form>
        <div class="container signin">

            <p>Wanna keep Shopping ? <a href="shopping.jsp">Buy more</a>.</p>
        </div>


        <script>
            function funtion() {
                var r = confirm("Are U Sure ?");
                if (r === false) {
                    even.preventDefault();
                }
            }
        </script>
    </body>
</html>

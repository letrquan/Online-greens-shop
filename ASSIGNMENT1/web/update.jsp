<%-- 
    Document   : update
    Created on : Jun 10, 2021, 1:44:58 PM
    Author     : quan2
--%>

<%@page import="zain.users.UserError"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" media="all" href="CSS/update.css">
        <link rel="shortcut icon" href="CSS/1879.ico">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Page</title>
    </head>
    <body>
        <c:if test="${sessionScope.LOGIN_USER == null}">
            <c:redirect url="shopping.jsp"></c:redirect>
        </c:if>
        <form action="MainController" method="POST">
            <div class="container">
                <h1>UPDATE</h1>
                <hr>

                <label for="id"><b>User ID</b></label>
                <input type="text" value="${sessionScope.LOGIN_USER.getUserID()}" name="userID" id="id" readonly>
                ${requestScope.USER_ERROR.getUserIDerror()}</br>
                
                <label for="fullName"><b>Full Name</b></label>
                <input type="text" value="${sessionScope.LOGIN_USER.getFullName()}" name="fullName" id="fullName" required>
                ${requestScope.USER_ERROR.getFullNameerror()}</br>
                
                <label for="psw"><b>Password</b></label>
                <input type="password" placeholder="Enter New Password" name="psw" id="psw" required>
                ${requestScope.USER_ERROR.getPassworderror()}</br>
                
                <label for="psw-repeat"><b>Repeat Password</b></label>
                <input type="password" placeholder="Repeat Password" name="psw-repeat" id="psw-repeat" required>
                ${requestScope.USER_ERROR.getConfirmpassworderror()}</br>
                
                <label for="phone"><b>Phone</b></label>
                <input type="text" value="${sessionScope.LOGIN_USER.getPhone()}" name="phone" id="phone" required>
                ${requestScope.USER_ERROR.getPhoneerror()}</br>
                
                <label for="address"><b>Address</b></label>
                <input type="text" value="${sessionScope.LOGIN_USER.getAddress()}" name="address" id="address" required>
                ${requestScope.USER_ERROR.getAddresserror()}</br>
                 <hr>
                <input type="hidden" name="roleID" value="${sessionScope.LOGIN_USER.getRoleID()}"/>
                <input type="hidden" name="statusID" value="${sessionScope.LOGIN_USER.getStatusID()}"/>
                <hr>
                <button type="submit" class="registerbtn" name="action" value="Confirm Update">UPDATE</button>
                <button type="button" class="registerbtn" onclick="location.href='shopping.jsp'">Cancel</button>
            </div>
        </form>
    </body>
</html>

<%-- 
    Document   : createUser
    Created on : Jun 16, 2021, 8:53:54 PM
    Author     : quan2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" media="all" href="CSS/createUser.css">
        <link rel="shortcut icon" href="CSS/1879.ico">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create User</title>
    </head>
    <body>
        <jsp:useBean id="USER_ERROR" class="zain.users.UserError">
            <jsp:setProperty property="userIDerror" value="1234" name="USER_ERROR" />
        </jsp:useBean>
        <%
            long millis = System.currentTimeMillis();
            java.sql.Date date = new java.sql.Date(millis);
            String createDate=date.toString();
        %>
        <form action="MainController" method="POST">
            <div class="container">
                <h1>Register</h1>
                <p>Please fill in this form to create an account.</p>
                <hr>

                <label for="id"><b>User ID</b></label>
                <input type="text" placeholder="Enter ID" name="userID" id="id" required>
                ${requestScope.USER_ERROR.getUserIDerror()}</br>

                <label for="fullName"><b>Full Name</b></label>
                <input type="text" placeholder="Full Name" name="fullName" id="fullName" required>
                ${requestScope.USER_ERROR.getFullNameerror()}</br>

                <label for="psw"><b>Password</b></label>
                <input type="password" placeholder="Enter Password" name="psw" id="psw" required>
                ${requestScope.USER_ERROR.getPassworderror()}</br>

                <label for="psw-repeat"><b>Repeat Password</b></label>
                <input type="password" placeholder="Repeat Password" name="psw-repeat" id="psw-repeat" required>
                ${requestScope.USER_ERROR.getConfirmpassworderror()}</br>

                <label for="phone"><b>Phone</b></label>
                <input type="text" placeholder="Phone" name="phone" id="phone" required>
                ${requestScope.USER_ERROR.getPhoneerror()}</br>

                <label for="address"><b>Address</b></label>
                <input type="text" placeholder="Address" name="address" id="address" required>
                ${requestScope.USER_ERROR.getAddresserror()}</br>
                <hr>
                <input type="hidden" name="roleID" value="2"/>
                <input type="hidden" name="statusID" value="S1"/>
                <input type="hidden" name="createDate" value="${createDate}"/>
                <hr>
                <button type="submit" class="registerbtn" name="action" value="Create">Register</button>
            </div>

            <div class="container signin">
                <p>Already have an account? <a href="shopping.jsp">Sign in</a>.</p>
            </div>
        </form>
    </body>
</html>

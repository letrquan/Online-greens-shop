<%-- 
    Document   : admin
    Created on : Jun 3, 2021, 9:02:03 AM
    Author     : ASUS
--%>

<%@page import="zain.users.UserError"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="zain.users.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Quicksand:wght@600&display=swap" rel="stylesheet"> 
        <link rel="shortcut icon" href="CSS/1879.ico">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" media="all" href="CSS/admin1.css">
        <title>Admin Page</title>
    </head>
    <body>

        <c:if test="${sessionScope.LOGIN_USER == null or sessionScope.LOGIN_USER.getRoleID().trim() != '1'}">
            <c:redirect url="shopping.jsp"></c:redirect>
        </c:if>
        <c:if test="${param == null }">
            <c:set var="param.search" value=""/>
        </c:if>

    <hi>WelCome :${sessionScope.LOGIN_USER.fullName}</hi>
        <c:url var="logoutLink" value="MainController"> 
            <c:param name="action" value="LogOut"></c:param>

    </c:url>
    <button>
        <a href="${logoutLink}">LogOut</a>
    </button>
    <form action="MainController">
        Search <input type="text" name="search" value="${param.search}"/>
        <input type="submit" name="action" value="Search"/>

    </form>

    <c:if test="${requestScope.LIST_USER != null}">
        <c:if test="${not empty requestScope.LIST_USER}">
            <table border="1">
                <thead>
                    <tr>
                        <th>NO</th>
                        <th>USER ID</th>
                        <th>FULL NAME</th>
                        <th>ROLE ID</th>
                        <th>PASS WORD</th>
                        <th>PHONE</th>
                        <th>ADDRESS</th>
                        <th>STATUS</th>
                        <th>CREATE DATE</th>
                        <th>UPDATE</th>
                        <th>DELETE</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="dto" varStatus="counter" items="${requestScope.LIST_USER}">
                    <form action="MainController">
                        <%
                            UserError error = (UserError) request.getAttribute("USER_ERROR");
                        %>
                        <tr>
                            <td>${counter.count}</td>
                            <td><input type="text" name="userID" value="${dto.userID}" readonly/></td>
                            <td>
                                <input type="text" name="fullName" value="${dto.fullName}"/>
                                ${error.fullNameerror}
                            </td>
                            <td>
                                <input type="text" name="roleID" value="${dto.roleID.trim()}"/>
                                ${error.roleIDerror}
                            </td>
                            <td>****</td>
                       
                            <td><input type="text" name="phone" value="${dto.phone}"/>
                                ${error.phoneerror}
                            </td>
                            <td><input type="text" name="address" value="${dto.address}"/>
                                ${error.addresserror}
                            </td>
                            <td><input type="text" name="statusID" value="${dto.statusID}" readonly/>
                                ${error.statusIDerror}
                            </td>
                            <td>${dto.createDate}</td>
                            <td>
                                <input type="hidden" name="search" value="${param.search}"/>
                                <input type="submit" name="action" value="Confirm Update"/>
                            </td>
                            <td>
                                <c:url var="deleteLink" value="MainController">
                                    <c:param name="action" value="Delete"/>
                                    <c:param name="userID" value="${dto.userID}"/>
                                    <c:param name="search" value="${param.search}"/>

                                </c:url>
                                <a href="${deleteLink}">Delete</a>
                            </td>
                        </tr>
                    </form>
                </c:forEach>
            </tbody>
        </table>

    </c:if>
    <c:if test="${empty requestScope.LIST_USER}">
        NO RECORD FOUND
    </c:if>
</c:if>

</body>
</html>

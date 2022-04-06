<%-- 
    Document   : detail
    Created on : Jul 5, 2021, 3:26:54 PM
    Author     : quan2
--%>

<%@page import="zain.products.ProductDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Tourney:ital,wght@1,200&display=swap" rel="stylesheet">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Quicksand:wght@600&display=swap" rel="stylesheet"> 
        <link rel="shortcut icon" href="CSS/1879.ico">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" media="all" href="CSS/detail.css">
        <title>Product Detail</title>
    </head>
    <body style="font-family: 'Quicksand', sans-serif;">
        <%
            if (session.getAttribute("LOGIN_USER") == null) {
        %>
        <button onclick="Login()" style="width:auto;">Login</button>
        <div id="id01" class="modal">
            <form class="modal-content animate" action="MainController" method="post">
                <div class="imgcontainer">
                    <span onclick="document.getElementById('id01').style.display = 'none'" class="close" title="Close Modal">&times;</span>
                    <img src="Image/user.png" alt="Avatar" class="avatar">
                </div>

                <div class="container1">
                    <label for="uname"><b>UserID</b></label>
                    <input type="text" placeholder="Enter UserID" name="uname" required>

                    <label for="psw"><b>Password</b></label>
                    <input type="password" placeholder="Enter Password" name="psw" required>

                    <button type="submit" name="action" value="Login">Login</button>
                    <label>
                        <input type="checkbox" checked="checked" name="remember"> Remember me

                    </label>
                </div>

                <div class="container1" style="background-color:#f1f1f1">
                    <span class="psw"><a href="createUser.jsp">Registration</a></span>
                    <button type="button" onclick="document.getElementById('id01').style.display = 'none'" class="cancelbtn">Cancel</button>

                </div>
            </form>
        </div>
        <%
        } else {
        %>
        <div class="user">
            <h4 style="display: inline-block">USER: ${sessionScope.LOGIN_USER.getFullName()}</h4>
            <form action="MainController" style="display: inline-block; margin-left: 1210px;">
                <button type="submit" name="action" value="LogOut" class="src-button">
                    LOG OUT
                </button>
                <button type="submit" name="action" value="view">
                    <image src="Image/trolley.png" alt="cart" id="cart"> View Cart
                </button> 
            </form>
        </div>
        <%
            }
        %>
        <a href="shopping.jsp" style="text-decoration: none;">
            <h1>BOOKSTORE 4.0</h1>
            <input type="hidden" value="${sessionScope.LOGIN_USER}" id="check" />
        </a>
        <%
            ProductDTO pro = (ProductDTO) request.getAttribute("PRODUCT_DETAIL");
            if (pro != null) {
        %>
        <div class="container">
            <div class="image">
                <img src="<%= pro.getImage()%>" alt="<%= pro.getProductName()%>" width="400" height="500" >
            </div>
            <div class="product">
                <div class="NP">
                    <h3><%= pro.getProductName()%></h3>
                    <p>Price: <%= pro.getMarketPrice()%> VND</p>
                </div>
                <div class="content">
                    <p>Description: <%= pro.getDescription()%></p>
                    <form action="MainController" onsubmit="myFuntion()">
                        <input type="hidden" name="product" value="<%= pro.getProductID()%>" />
                        <input type="number" name="quantity" value="1" min="1" max="<%= pro.getQuantity()%>"/>
                        <button type="submit" name="action" value="add" on>ADD TO CART</button>
                    </form>
                </div>
            </div>  
        </div>
        <%
            }
        %>
        <script>
            function myFuntion() {
                let x = document.getElementById("check").value;
                if (x === "") {
                    alert("Please Login Before Add");
                }
            }
            function Login() {
                document.getElementById('id01').style.display = 'block';
            }
        </script>
    </body>
</html>

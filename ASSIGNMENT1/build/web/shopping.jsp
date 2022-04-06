
<%@page import="zain.products.ProductDao"%>
<%@page import="java.util.List"%>
<%@page import="zain.products.ProductDTO"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html>
    <head>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Tourney:ital,wght@1,200&display=swap" rel="stylesheet">
        <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="CSS/1879.ico">
        <link rel="stylesheet" type="text/css" media="all" href="CSS/shopping.css">
        <title>Book Store</title>
    </head>
    <body>
        <%
            if (session.getAttribute("LOGIN_USER") == null) {
        %>
        <button onclick="LoginForm()" style="width:auto;">Login</button>
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

                    <button type="submit" name="action" value="Login" >Login</button>
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
            <h4 style="display: inline-block;">USER: ${sessionScope.LOGIN_USER.getFullName()}</h4>
            <button onclick="location.href = 'update.jsp'">Update</button>
            <form action="MainController" style="display: inline-block; margin-left: 1150px;">
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
            String search = (String) request.getParameter("search");
        %>
        <h1><img src="CSS/1879.ico" alt="logo" width="40" height="40" style="border-radius: 5px;"/> Q Market</h1>
        <input type="hidden" value="${sessionScope.LOGIN_USER}" id="check" />
        <form action="MainController">
            <div class="search-bar">
                <input name="search" value="${search}" type="text" placeholder="search..." id="search" />
                <button type="submit" name="action" value="product" class="src-button">Search</button>
            </div>
        </form>
        <%
            ProductDao dao = new ProductDao();
            List<ProductDTO> list = (List<ProductDTO>) request.getAttribute("LIST_PRODUCT");
            if (list == null) {
                list = dao.getProductbyName("");
            }
        %>
        <div class="product_list">
            <%
                for (ProductDTO product : list) {
            %>
            <div class="container">
                <div class="card">
                    <div class="image" >
                        <form action="MainController">
                            <input type="hidden" name="product-item" value="<%= product.getProductID()%> " />
                            <input type="hidden" name="action" value="detail"/>
                            <input id="image" src="<%= product.getImage()%>" alt="Submit" type="image" width="230" height="250">
                        </form>
                    </div>
                    <div class="content">
                        <p>Description: <%= product.getDescription()%></p>
                    </div>
                    <a class="more"></a>
                </div>
                <div class="add">
                    <h3><%= product.getProductName()%></h3>
                    <p style="color: aquamarine">Loại: <%= dao.getCategoryNamebyID(product.getCategoryID())%> </p>
                    <p class="price" style="color: aquamarine">Price: <%= product.getMarketPrice()%> VND</p>
                    <%
                        if (product.getQuantity() > 0) {
                    %>
                    <form action="MainController" onsubmit="myFuntion();">
                        <input type="hidden" name="product" value="<%= product.getProductID()%>" />
                        <input type="number" name="quantity" value="1" min="1" max="<%= product.getQuantity()%>"/>
                        <button type="submit" name="action" value="add">ADD TO CART</button>
                    </form>
                    <%
                    } else {
                    %>
                    <p style="color: whitesmoke">RUN OUT</p>
                    <%
                        }
                    %>
                </div>
            </div>
            <%
                }
            %>
        </div>
        <script>
                    function myFuntion() {
                    let x = document.getElementById("check").value;
                            if (x === "") {
                    alert("Please Login Before Add");
                    }
                    }
            function LoginForm() {
            document.getElementById('id01').style.display = 'block';
            }
        </script>
    </body>
</html>

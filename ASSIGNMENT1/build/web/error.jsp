<%-- 
    Document   : error
    Created on : Jun 3, 2021, 10:11:47 AM
    Author     : quan2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Quicksand:wght@600&display=swap" rel="stylesheet"> 
        <link rel="shortcut icon" href="CSS/1879.ico">
        <link rel="stylesheet" type="text/css" media="all" href="CSS/error.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ERROR Page</title>
    </head>
    <body>
        <h1><%= session.getAttribute("ERROR_MESSAGE")%> </h1>
        <a href="shopping.jsp">
            <button>Back to Shopping Page</button>
        </a>
    </body>
</html>

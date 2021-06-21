<%-- 
    Document   : home
    Created on : Jun 9, 2021, 9:54:14 PM
    Author     : 851314
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        <h1>Home Page</h1>
        <form method="POST" action="home">
            <h3>Hello ${username}.</h3>
            <a href="login?logout">Log out</a>
        </form>
    </body>
</html>

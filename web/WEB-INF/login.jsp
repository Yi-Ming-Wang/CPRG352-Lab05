<%-- 
    Document   : login
    Created on : 15-Oct-2021, 7:56:24 PM
    Author     : adamw
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="Style/main.css" type="text/css"/>   
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Login</h1>
        <div>
        <form method="post" action="login">
            <label>Username:</label>
            <input type="text" name="USERNAME" value="${USER}"><br>
            <label>Password:</label>
            <input type="password" name="PASSWORD" value="${PASSWORD}"><br>        
            <label>&nbsp;</label>
            <input type="submit" value="Log In">
           
        </form>
        </div>    
        <div>
        <p><i>${MESSAGE}</i></p>
        </div>
</body>
</html>

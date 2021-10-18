<%-- 
    Document   : home
    Created on : 17-Oct-2021, 1:53:46 PM
    Author     : adamw
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="Style/main.css" type="text/css"/>   
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        <h1>Hello Page</h1>
        <div>
        <p><i>Hello ${USER}</i></p>    
        <p><a href="login?operation=logout">Log out</a></p>
        </div>
    </body>
</html>

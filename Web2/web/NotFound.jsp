<%-- 
    Document   : NotFound
    Created on : 17.08.2021, 21:11:57
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" isErrorPage="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Not found!!</h1>
        <p>
        <%= exception.getMessage() %>
    </body>
</html>

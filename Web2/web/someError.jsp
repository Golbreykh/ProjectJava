<%-- 
    Document   : someError
    Created on : 17.08.2021, 20:57:30
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" isErrorPage="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error Page</title>
    </head>
    <body>
        Some Error!
        <p>
        <%= exception.getMessage() %>
    </body>
</html>

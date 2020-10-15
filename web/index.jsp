<%-- 
    Document   : index
    Created on : 09/10/2020, 09:20:17 AM
    Author     : Tatiana Duque
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Panel | Estumatricula</title>
    </head>
    <body>
        <h1>Inicio de sesión</h1>
        <%
            String nombres = (String) request.getAttribute("nombres");
            String apellidos = (String) request.getAttribute("apellidos");
            String email = (String) session.getAttribute("email");
            String dni = (String) session.getAttribute("dni");
        %>
        <p><%= nombres %></p>
        <p><%= apellidos %></p>
        <p><%= email %></p>
        <p><%= dni %></p>
    </body>
</html>

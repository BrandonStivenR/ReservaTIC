<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="modelos.Usuario" %>
<%
    Usuario u = (Usuario) session.getAttribute("usuarioLogueado");
    if (u == null) {
        response.sendRedirect("login.html");
        return;
    }
%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Bienvenida - ReservaTIC</title>
</head>
<body>
    <h1>Bienvenido, <%= u.getNombreCompleto() %></h1>
    <p>Rol: <%= u.getRol() %></p>
    <p>Correo: <%= u.getCorreoInstitucional() %></p>
    <p><a href="usuarios">Ver usuarios</a> | <a href="login?accion=salir">Cerrar sesión</a></p>
</body>
</html>
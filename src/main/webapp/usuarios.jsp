<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List, modelos.Usuario" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Usuarios - ReservaTIC</title>
</head>
<body>
    <h1>Lista de usuarios</h1>

    <%
        String mensaje = (String) request.getAttribute("mensaje");
        if (mensaje != null) {
    %>
        <p style="color:red;"><%= mensaje %></p>
    <% } %>

    <table border="1" cellpadding="6">
        <tr>
            <th>ID</th><th>Nombre</th><th>Documento</th><th>Correo</th><th>Rol</th><th>Acciones</th>
        </tr>
        <%
            List<Usuario> lista = (List<Usuario>) request.getAttribute("listaUsuarios");
            if (lista != null) {
                for (Usuario u : lista) {
        %>
        <tr>
            <td><%= u.getIdUsuario() %></td>
            <td><%= u.getNombreCompleto() %></td>
            <td><%= u.getDocumentoIdentidad() %></td>
            <td><%= u.getCorreoInstitucional() %></td>
            <td><%= u.getRol() %></td>
            <td>
                <a href="usuarios?accion=editar&id=<%= u.getIdUsuario() %>">Editar</a> |
                <a href="usuarios?accion=eliminar&id=<%= u.getIdUsuario() %>"
                   onclick="return confirm('¿Eliminar este usuario?');">Eliminar</a>
            </td>
        </tr>
        <%
                }
            }
        %>
    </table>
    <p><a href="registro.html">Nuevo usuario</a> | <a href="index.html">Inicio</a></p>
</body>
</html>
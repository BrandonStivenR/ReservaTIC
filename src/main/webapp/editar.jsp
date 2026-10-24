<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="modelos.Usuario" %>
<%
    Usuario u = (Usuario) request.getAttribute("usuario");
    if (u == null) {
        response.sendRedirect("usuarios");
        return;
    }
%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Editar usuario - ReservaTIC</title>
</head>
<body>
    <h1>Editar usuario</h1>
    <form action="usuarios" method="post">
        <input type="hidden" name="idUsuario" value="<%= u.getIdUsuario() %>">
        <p>Nombre completo: <input type="text" name="nombreCompleto" value="<%= u.getNombreCompleto() %>" required></p>
        <p>Documento: <input type="text" name="documentoIdentidad" value="<%= u.getDocumentoIdentidad() %>" required></p>
        <p>Correo: <input type="email" name="correoInstitucional" value="<%= u.getCorreoInstitucional() %>" required></p>
        <p>Rol:
            <select name="rol">
                <option value="Estudiante" <%= "Estudiante".equals(u.getRol()) ? "selected" : "" %>>Estudiante</option>
                <option value="Docente" <%= "Docente".equals(u.getRol()) ? "selected" : "" %>>Docente</option>
            </select>
        </p>
        <p><button type="submit">Guardar cambios</button></p>
    </form>
    <a href="usuarios">Cancelar</a>
</body>
</html>
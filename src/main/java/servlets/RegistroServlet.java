package servlets;

import dao.UsuarioDAO;
import modelos.Usuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/registro")
public class RegistroServlet extends HttpServlet {

    private final UsuarioDAO usuarioDAO = new UsuarioDAO();

    // GET: muestra el formulario
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("registro.html");
    }

    // POST: recibe los datos del formulario y los guarda
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        Usuario usuario = new Usuario();
        usuario.setNombreCompleto(request.getParameter("nombreCompleto"));
        usuario.setDocumentoIdentidad(request.getParameter("documentoIdentidad"));
        usuario.setCorreoInstitucional(request.getParameter("correoInstitucional"));
        usuario.setContrasena(request.getParameter("contrasena"));
        usuario.setRol(request.getParameter("rol"));

        if (usuarioDAO.insertarUsuario(usuario)) {
            response.sendRedirect("usuarios");
        } else {
            request.setAttribute("mensaje", "No se pudo registrar. Revisa los datos (documento o correo repetido).");
            request.getRequestDispatcher("usuarios.jsp").forward(request, response);
        }
    }
}
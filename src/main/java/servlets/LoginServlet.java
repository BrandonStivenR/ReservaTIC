package servlets;

import dao.UsuarioDAO;
import modelos.Usuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private final UsuarioDAO usuarioDAO = new UsuarioDAO();

    // GET: cierra sesión (?accion=salir) o muestra el login
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if ("salir".equals(request.getParameter("accion"))) {
            HttpSession sesion = request.getSession(false);
            if (sesion != null) {
                sesion.invalidate();
            }
        }
        response.sendRedirect("login.html");
    }

    // POST: valida credenciales
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String correo = request.getParameter("correoInstitucional");
        String contrasena = request.getParameter("contrasena");

        Usuario usuario = usuarioDAO.autenticar(correo, contrasena);

        if (usuario != null) {
            request.getSession().setAttribute("usuarioLogueado", usuario);
            response.sendRedirect("bienvenida.jsp");
        } else {
            response.sendRedirect("login.html?error=1");
        }
    }
}
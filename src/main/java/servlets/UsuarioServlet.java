package servlets;

import dao.UsuarioDAO;
import modelos.Usuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/usuarios")
public class UsuarioServlet extends HttpServlet {

    private final UsuarioDAO usuarioDAO = new UsuarioDAO();

    // GET: listar, editar (carga el formulario) o eliminar
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");

        if ("eliminar".equals(accion)) {
            int id = Integer.parseInt(request.getParameter("id"));
            usuarioDAO.eliminarUsuario(id);
            response.sendRedirect("usuarios");
            return;
        }

        if ("editar".equals(accion)) {
            int id = Integer.parseInt(request.getParameter("id"));
            Usuario usuario = usuarioDAO.buscarPorId(id);
            request.setAttribute("usuario", usuario);
            request.getRequestDispatcher("editar.jsp").forward(request, response);
            return;
        }

        request.setAttribute("listaUsuarios", usuarioDAO.listarUsuarios());
        request.getRequestDispatcher("usuarios.jsp").forward(request, response);
    }

    // POST: guardar los cambios de la edición
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        Usuario usuario = new Usuario();
        usuario.setIdUsuario(Integer.parseInt(request.getParameter("idUsuario")));
        usuario.setNombreCompleto(request.getParameter("nombreCompleto"));
        usuario.setDocumentoIdentidad(request.getParameter("documentoIdentidad"));
        usuario.setCorreoInstitucional(request.getParameter("correoInstitucional"));
        usuario.setRol(request.getParameter("rol"));

        usuarioDAO.actualizarUsuario(usuario);
        response.sendRedirect("usuarios");
    }
}
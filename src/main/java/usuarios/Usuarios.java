package usuarios;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Usuarios", value = "/Usuarios")
public class Usuarios extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UsuariosDAO usuariosDAO = new UsuariosDAO();

        if (request.getParameter("create") != null) {
            int cedula;
            String user, name, password, email;
            cedula = Integer.parseInt(request.getParameter("cedula"));
            user = request.getParameter("user");
            name = request.getParameter("name");
            password = request.getParameter("password");
            email = request.getParameter("email");

            UsuariosDTO usuariosDTO = new UsuariosDTO(cedula, user, password, name, email);
            if (usuariosDAO.insertUser(usuariosDTO)) {
                response.sendRedirect("users.jsp?msg=Usuario agregado");
            } else {
                response.sendRedirect("users.jsp?msg=Error al agregar");
            }
        }

    }
}

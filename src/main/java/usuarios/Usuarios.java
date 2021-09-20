package usuarios;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.swing.*;
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
            } else{
                response.sendRedirect("users.jsp?msg=Error al agregar");
            }
        }

        if (request.getParameter("search")!=null) {
            int cedula;
            String email, name, password, user;
            cedula = Integer.parseInt(request.getParameter("cedula"));
            UsuariosDTO usuario = usuariosDAO.searchUser(cedula);
            if (usuario != null) {
                cedula = usuario.getCedula();
                email = usuario.getEmail();
                name = usuario.getName();
                password = usuario.getPassword();
                user = usuario.getUser();
                response.sendRedirect("users.jsp?cedula=" + cedula +
                        "&&email=" + email + "&&name=" + name + "&&password=" + password + "&&user=" + user);
            } else {
                response.sendRedirect("users.jsp?msg= Usuario no encontrado");
            }

        }
        if (request.getParameter("update") !=null){
            int cedula;
            String email, name,password,user;
            cedula = Integer.parseInt(request.getParameter("cedula"));
            email = request.getParameter("email");
            name = request.getParameter("name");
            password = request.getParameter("password");
            user = request.getParameter("user");

            UsuariosDTO usuariosDTO = new UsuariosDTO(cedula, user, password, name, email);
            if (usuariosDAO.updateUser(usuariosDTO)) {
                response.sendRedirect("users.jsp?msg=Usuario modificado");
            } else {
                response.sendRedirect("users.jsp?msg=Error al modificar");
            }

        }
        if (request.getParameter("delete")!=null){
            int cedula;
            cedula = Integer.parseInt(request.getParameter("cedula"));
            int accept = JOptionPane.showInternalConfirmDialog(null,"¿Eliminar cliente con cedula: ?"+cedula);
            if (accept == 0){
                if (usuariosDAO.deleteUser(cedula)){
                    response.sendRedirect("users.jsp?msg=Usuario eliminado");
                } else {
                    response.sendRedirect("users.jsp?msg=Error al eliminar");
                }
            }else {
                response.sendRedirect("clients.jsp");
            }
        }

    }
}

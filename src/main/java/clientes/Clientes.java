package clientes;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Clientes", value = "/Clientes")
public class Clientes extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ClientesDAO clientsDAO = new ClientesDAO();

        if (request.getParameter("create") != null) {
            int idC, telephono;
            String adress, email,name;
            idC = Integer.parseInt(request.getParameter("cedula"));
            adress = request.getParameter("user");
            email = request.getParameter("name");
            name = request.getParameter("password");
            telephono = Integer.parseInt(request.getParameter("telefono"));

            ClientesDTO clientsDTO = new ClientesDTO(idC, adress, email, name, telephono);
            if (clientsDAO.insertUser(clientsDTO)) {
                response.sendRedirect("users.jsp?msg=Cliente agregado");
            } else {
                response.sendRedirect("users.jsp?msg=Error al agregar");
            }
        }

    }
}

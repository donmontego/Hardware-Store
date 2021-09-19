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
            int cedula;
            String address, email,name,phone;
            cedula = Integer.parseInt(request.getParameter("cedula"));
            address = request.getParameter("address");
            email = request.getParameter("email");
            name = request.getParameter("name");
            phone = request.getParameter("phone");

            ClientesDTO clientsDTO = new ClientesDTO(cedula, address, email, name, phone);
            if (clientsDAO.insertUser(clientsDTO)) {
                response.sendRedirect("users.jsp?msg=Cliente agregado");
            } else {
                response.sendRedirect("users.jsp?msg=Error al agregar");
            }
        }

    }
}

package clientes;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.swing.*;
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
            if (clientsDAO.insertclient(clientsDTO)) {
                response.sendRedirect("clients.jsp?msg=Cliente agregado");
            } else {
                response.sendRedirect("clients.jsp?msg=Error al agregar");
            }
        }
        if (request.getParameter("search")!=null) {
            int cedula;
            String address, email, name, phone;
            cedula = Integer.parseInt(request.getParameter("cedula"));
            ClientesDTO client = clientsDAO.searchCliente(cedula);
            if (client != null) {
                cedula = client.getCedula();
                address = client.getAdress();
                email = client.getEmail();
                name = client.getName();
                phone = client.getPhone();
                response.sendRedirect("clients.jsp?cedula=" + cedula +
                        "&&address=" + address + "&&email=" + email + "&&name=" + name + "&&phone=" + phone);
            } else {
                response.sendRedirect("clients.jsp?msg= Cliente no encontrado");
            }

        }
        if (request.getParameter("update") !=null){
            int cedula;
            String address, email,name,phone;
            cedula = Integer.parseInt(request.getParameter("cedula"));
            address = request.getParameter("address");
            email = request.getParameter("email");
            name = request.getParameter("name");
            phone = request.getParameter("phone");

            ClientesDTO clientsDTO = new ClientesDTO(cedula, address, email, name, phone);
            if (clientsDAO.updateClient(clientsDTO)) {
                response.sendRedirect("clients.jsp?msg=Cliente modificado");
            } else {
                response.sendRedirect("clients.jsp?msg=Error al modificado");
            }

        }
        if (request.getParameter("delete")!=null){
            int cedula;
            cedula = Integer.parseInt(request.getParameter("cedula"));
            int accept = JOptionPane.showInternalConfirmDialog(null,"¿Eliminar cliente con cedula: ?"+cedula);
            if (accept == 0){
                if (clientsDAO.deleteclient(cedula)){
                    response.sendRedirect("clients.jsp?msg=Cliente eliminado");
                } else {
                    response.sendRedirect("clients.jsp?msg=Error al eliminar");
                }
            }else {
                response.sendRedirect("clients.jsp");
            }
        }


    }
}

package clientes;

import utils.SessionChecker;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.swing.*;
import java.io.IOException;

@WebServlet(name = "Clientes", value = "/Clientes")
public class Clientes extends SessionChecker {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        validate(request,response);

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
                request.setAttribute("RESULT","success-msg");
                request.setAttribute("MESSAGE","Cliente agregado con éxito.");
            } else {
                request.setAttribute("RESULT","error-msg");
                request.setAttribute("MESSAGE","Error al crear el cliente.");
            }
            request.getRequestDispatcher("WEB-INF/views/clients.jsp").forward(request, response);
        }
        if (request.getParameter("search")!=null) {
            int cedula;
            cedula = Integer.parseInt(request.getParameter("cedula"));
            ClientesDTO client = clientsDAO.searchCliente(cedula);
            if (client != null) {
               request.setAttribute("CLIENT",client);
            } else {
                request.setAttribute("RESULT","error-msg");
                request.setAttribute("MESSAGE","Cliente no encontrado.");
            }
            request.getRequestDispatcher("WEB-INF/views/clients.jsp").forward(request, response);

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
                request.setAttribute("RESULT","success-msg");
                request.setAttribute("MESSAGE","Cliente modificado.");
            } else {
                request.setAttribute("RESULT","error-msg");
                request.setAttribute("MESSAGE","Error al modificar cliente.");
            }
            request.getRequestDispatcher("WEB-INF/views/clients.jsp").forward(request, response);

        }
        if (request.getParameter("delete")!=null){
            int cedula;
            cedula = Integer.parseInt(request.getParameter("cedula"));
            int accept = JOptionPane.showInternalConfirmDialog(null,"¿Eliminar cliente con cedula: ?"+cedula);
            if (accept == 0){
                if (clientsDAO.deleteclient(cedula)){
                    request.setAttribute("RESULT","success-msg");
                    request.setAttribute("MESSAGE","Cliente eliminado.");
                } else {
                    request.setAttribute("RESULT","error-msg");
                    request.setAttribute("MESSAGE","Error al eliminar el cliente.");
                }
            }
            request.getRequestDispatcher("WEB-INF/views/clients.jsp").forward(request, response);
        }


    }
}

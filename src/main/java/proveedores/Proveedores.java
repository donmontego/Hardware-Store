package proveedores;

import clientes.ClientesDTO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Proveedores", value = "/Proveedores")
public class Proveedores extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProveedoresDAO supplierDAO= new ProveedoresDAO();

        if (request.getParameter("create") != null) {
            int nit, telephono;
            String city, adress, name;
            nit = Integer.parseInt(request.getParameter("cedula"));
            city = request.getParameter("user");
            adress = request.getParameter("name");
            name = request.getParameter("password");
            telephono = Integer.parseInt(request.getParameter("telefono"));

            ProveedoresDTO supplierDTO = new ProveedoresDTO(nit, city, adress, name, telephono);
            if (supplierDAO.insertUser(supplierDTO)) {
                response.sendRedirect("users.jsp?msg=Proveedor agregado");
            } else {
                response.sendRedirect("users.jsp?msg=Error al agregar");
            }
        }
    }
}

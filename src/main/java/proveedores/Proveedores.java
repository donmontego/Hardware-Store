package proveedores;

import utils.SessionChecker;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.swing.*;
import java.io.IOException;

@WebServlet(name = "Proveedores", value = "/Proveedores")
public class Proveedores extends SessionChecker {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        validate(request, response);
        ProveedoresDAO proveedoresDAO = new ProveedoresDAO();

        String nit = "", name = "", address = "", phone = "", city = "";

        if (request.getParameter("create") != null) {


            nit = request.getParameter("nit");
            name = request.getParameter("name");
            address = request.getParameter("address");
            phone = request.getParameter("phone");
            city = request.getParameter("city");

            ProveedoresDTO proveedor = new ProveedoresDTO(nit, name, address, phone, city);
            int resultado = proveedoresDAO.insertProvider(proveedor);
            if (resultado == 0) {
                request.setAttribute("RESULT","success-msg");
                request.setAttribute("MESSAGE","Proveedor agregado con éxito.");
            } else if (resultado == 2) {
                request.setAttribute("RESULT","error-msg");
                request.setAttribute("MESSAGE","NIT ya registrada.");
            }else {
                request.setAttribute("RESULT","error-msg");
                request.setAttribute("MESSAGE","Error al crear el proveedor, comuniquese con el administrador.");
            }
            request.getRequestDispatcher("WEB-INF/views/providers.jsp").forward(request, response);
        }

        if (request.getParameter("search") != null) {

            nit = request.getParameter("nit");
            ProveedoresDTO proveedor = proveedoresDAO.searchProveedor(nit);

            if (proveedor != null) {
                request.setAttribute("PROVIDER",proveedor);
            } else {
                request.setAttribute("RESULT","error-msg");
                request.setAttribute("MESSAGE","Proveedor no encontrado.");
            }
            request.getRequestDispatcher("WEB-INF/views/providers.jsp").forward(request, response);
        }

        if (request.getParameter("update") != null) {

            nit = request.getParameter("nit");
            name = request.getParameter("name");
            address = request.getParameter("address");
            phone = request.getParameter("phone");
            city = request.getParameter("city");

            ProveedoresDTO proveedor = new ProveedoresDTO(nit, name, address, phone, city);
            if (proveedoresDAO.updateProvider(proveedor)) {
                request.setAttribute("RESULT","success-msg");
                request.setAttribute("MESSAGE","Proveedor modificado con éxito.");
            } else {
                request.setAttribute("RESULT","error-msg");
                request.setAttribute("MESSAGE","Error al modificar el proveedor.");
            }
            request.getRequestDispatcher("WEB-INF/views/providers.jsp").forward(request,response);
        }

        if (request.getParameter("delete") != null) {

            nit = request.getParameter("nit");
            int accept = JOptionPane.showConfirmDialog(null, "¿Eliminar proveedor con NIT: ?" + nit);
            if (accept == 0) {
                if (proveedoresDAO.deleteProvider(nit)) {
                    request.setAttribute("RESULT","success-msg");
                    request.setAttribute("MESSAGE","Proveedor eliminado.");
                } else {
                    request.setAttribute("RESULT","error-msg");
                    request.setAttribute("MESSAGE","Error al eliminar el proveedor.");
                }
            }
            request.getRequestDispatcher("WEB-INF/views/providers.jsp").forward(request, response);
        }
    }
}

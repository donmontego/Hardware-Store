package proveedores;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.swing.*;
import java.io.IOException;

@WebServlet(name = "Proveedores", value = "/Proveedores")
public class Proveedores extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProveedoresDAO proveedoresDAO = new ProveedoresDAO();

        if (request.getParameter("create") != null) {
            int nit;
            String name, address, phone, city;
            nit = Integer.parseInt(request.getParameter("nit"));
            name = request.getParameter("name");
            address = request.getParameter("address");
            phone = request.getParameter("phone");
            city = request.getParameter("city");

            ProveedoresDTO proveedor = new ProveedoresDTO(nit, name, address, phone, city);
            if (proveedoresDAO.insertProvider(proveedor)) {
                response.sendRedirect("providers.jsp?msg=Proveedor Agregado");
            } else {
                response.sendRedirect("providers.jsp?msg=Error al agregar proveedor");
            }
        }

        if (request.getParameter("search") != null) {
            int nit;
            String name, address, phone, city;
            nit = Integer.parseInt(request.getParameter("nit"));
            ProveedoresDTO proveedor = proveedoresDAO.searchProveedor(nit);

            if (proveedor != null) {
                nit = proveedor.getNit();
                name = proveedor.getName();
                address = proveedor.getAddress();
                phone = proveedor.getPhone();
                city = proveedor.getCity();
                response.sendRedirect("providers.jsp?nit=" + nit + "&&name=" + name + "&&address=" + address + "&&phone=" + phone + "&&city=" + city);
            } else {
                response.sendRedirect("providers.jsp?msg=Proveedor no encontrado");
            }
        }

        if (request.getParameter("update") != null) {
            int nit;
            String name, address, phone, city;
            nit = Integer.parseInt(request.getParameter("nit"));
            name = request.getParameter("name");
            address = request.getParameter("address");
            phone = request.getParameter("phone");
            city = request.getParameter("city");

            ProveedoresDTO proveedor = new ProveedoresDTO(nit, name, address, phone, city);
            if (proveedoresDAO.updateProvider(proveedor)) {
                response.sendRedirect("providers.jsp?msg=Proveedor modificado");
            } else {
                response.sendRedirect("providers.jsp?msg=Error al modificar el proveedor");
            }
        }

        if (request.getParameter("delete") != null) {
            int nit;
            nit = Integer.parseInt(request.getParameter("nit"));
            int accept = JOptionPane.showConfirmDialog(null, "¿Eliminar proveedor con NIT: ?" + nit);
            if (accept == 0) {
                if (proveedoresDAO.deleteProvider(nit)) {
                    response.sendRedirect("providers.jsp?msg=Proveedor eliminado");
                } else {
                    response.sendRedirect("providers.jsp?msg=Error al eliminar el proveedor");
                }
            } else {
                response.sendRedirect("providers.jsp");
            }
        }
    }
}

package ventas;

import clientes.ClientesDAO;
import clientes.ClientesDTO;
import com.google.gson.Gson;
import productos.ProductosDAO;
import productos.ProductosDTO;
import utils.SessionChecker;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "Ventas", value = "/Ventas")
public class Ventas extends SessionChecker {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        validate(request,response);

       String option = request.getParameter("option");
       if (option.equals("clientes")) {
           ClientesDAO clientesDAO = new ClientesDAO();
           ArrayList<ClientesDTO> listaClientes = new ArrayList<>();
           listaClientes = clientesDAO.cargarClientes();
           PrintWriter writer = response.getWriter();
           Gson json = new Gson();
           writer.print(json.toJson(listaClientes));
       }
        if (option.equals("productos")) {
            ProductosDAO productosDAO = new ProductosDAO();
            ArrayList<ProductosDTO> listaProductos = new ArrayList<>();
            listaProductos = productosDAO.cargarProductos();
            PrintWriter writer = response.getWriter();
            Gson json = new Gson();
            writer.print(json.toJson(listaProductos));
        }
    }
}

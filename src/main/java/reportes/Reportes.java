package reportes;

import clientes.ClientesDAO;
import clientes.ClientesDTO;
import com.google.gson.Gson;
import usuarios.UsuariosDAO;
import usuarios.UsuariosDTO;
import utils.SessionChecker;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "Reportes", value = "/Reportes")
public class Reportes extends SessionChecker {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    validate(request, response);

    String option = request.getParameter("option");
        PrintWriter out = response.getWriter();
        Gson datos = new Gson();

    if (option.equals("users")) {
        UsuariosDAO usuariosDAO = new UsuariosDAO();
        ArrayList<UsuariosDTO> listaUsuarios = new ArrayList<>();
        listaUsuarios = usuariosDAO.allUsers();
        out.println(datos.toJson(listaUsuarios));
    }

    if (option.equals("clients")) {
        ClientesDAO clientesDAO = new ClientesDAO();
        ArrayList<ClientesDTO> listaClientes = new ArrayList<>();
        listaClientes = clientesDAO.allClients();
        out.println(datos.toJson(listaClientes));
    }

    if (option.equals("sales")) {
        ReportesVentasDAO reportesVentasDAO = new ReportesVentasDAO();
        ArrayList<ReportesVentasDTO> listaSales = new ArrayList<>();
        listaSales = reportesVentasDAO.totalSales();
        out.println(datos.toJson(listaSales));
    }
    }
}

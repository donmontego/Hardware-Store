package ventas;

import clientes.ClientesDAO;
import clientes.ClientesDTO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import productos.ProductosDAO;
import productos.ProductosDTO;
import usuarios.UsuariosDTO;
import utils.SessionChecker;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;

@WebServlet(name = "Ventas", value = "/Ventas")
public class Ventas extends SessionChecker {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        validate(request, response);

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

        if (option.equals("generate")) {
            VentasDAO ventasDAO = new VentasDAO();
            DetalleVentaDAO detalleVentaDAO = new DetalleVentaDAO();
            ProductosDTO productosDTO = null;
            ProductosDAO productosDAO = new ProductosDAO();
            PrintWriter out = response.getWriter();

            int cedulaCliente = Integer.parseInt(request.getParameter("clienteCedula"));
            int cedulaUsuario = ((UsuariosDTO) request.getSession().getAttribute("CURRENT_USER")).getCedula();
//            System.out.println(cedulaCliente);
//            System.out.println(cedulaUsuario);
            Gson gson = new Gson();
            String jsonProductos = request.getParameter("productos");
            System.out.println(jsonProductos);
            DetalleVentaDTO[] productos = gson.fromJson(jsonProductos, DetalleVentaDTO[].class);


            int codigoVenta = ventasDAO.insertVenta(new VentasDTO(cedulaCliente, cedulaUsuario));
            System.out.println("codigo venta:" + codigoVenta);
            if (codigoVenta == 0) {
                request.setAttribute("RESULT", "error-msg");
                request.setAttribute("MESSAGE", "Error registar el consecutivo de la venta.");
                request.getRequestDispatcher("WEB-INF/views/sales.jsp").forward(request, response);
            } else {
                for (DetalleVentaDTO venta : productos) {
                    productosDTO = productosDAO.searchProducto(venta.getCodigoProduto());
                    venta.setCodigoVenta(codigoVenta);
                    venta.setValorVenta(productosDTO.getPrecio_venta());
                    venta.setValorIva(productosDTO.getIva_compra());
                    venta.setValorTotal(venta.getValorVenta() * venta.getCantidadProduto());
                    System.out.println(venta);

                    if (!detalleVentaDAO.insertDatalleVenta(venta)) {
                        request.setAttribute("RESULT", "error-msg");
                        request.setAttribute("MESSAGE", "Error al registar detalles de la venta.");
                        request.getRequestDispatcher("WEB-INF/views/sales.jsp").forward(request, response);
                    }
                }
                System.out.println("Success!");

                VentasDTO ventaTotal = ventasDAO.searchVenta(codigoVenta);
                System.out.println(ventaTotal);

                ArrayList<String> answerList = new ArrayList<>();
                answerList.add("success-msg");
                answerList.add("Venta registrada satisfactoriamente con el consecutivo "+String.valueOf(codigoVenta));
                answerList.add(String.valueOf(codigoVenta));
                answerList.add(String.valueOf(ventaTotal.getTotalVenta()));
                answerList.add(String.valueOf(ventaTotal.getIvaVenta()));
                answerList.add(String.valueOf(ventaTotal.getValorVenta()));

                out.println(gson.toJson(answerList));

//                request.setAttribute("VENTA", ventaTotal);
//                request.setAttribute("RESULT", "success-msg");
////                request.setAttribute("CONSEC",codigoVenta);
//                request.setAttribute("MESSAGE", "Venta registrada exitosamente bajo el consecutivo " + codigoVenta);
//                out.println(data.toJson("success..."));
//                request.getRequestDispatcher("WEB-INF/views/users.jsp").forward(request, response);
            }
        }
    }
}

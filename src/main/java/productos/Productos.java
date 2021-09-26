package productos;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.swing.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

@WebServlet(name = "Productos", value = "/Productos")
@MultipartConfig
public class Productos extends HttpServlet {

    private static final long serialVersionUID = 1L;


    public Productos() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ProductosDAO productosDAO = new ProductosDAO();

        if (request.getParameter("search")!=null) {
            int codigo_producto;
            double iva_compra, precio_compra, precio_venta;
            String nit_proveedor, nombre_producto;

            codigo_producto = Integer.parseInt(request.getParameter("codigo_producto"));
            ProductosDTO productos = productosDAO.searchProducto(codigo_producto);

            if (productos!= null) {
                codigo_producto = productos.getCodigo_producto();
                iva_compra = productos.getIva_compra();
                nit_proveedor = productos.getNit_proveedor();
                nombre_producto = productos.getNombre_producto();
                precio_compra = productos.getPrecio_compra();
                precio_venta = productos.getPrecio_venta();
                response.sendRedirect("products.jsp?codigo_producto="+codigo_producto+"&&iva_compra="+iva_compra+
                        "&&nit_proveedor="+nit_proveedor+"&&nombre_producto="+nombre_producto+
                        "&&precio_compra="+precio_compra+"&&precio_venta="+precio_venta);

            }else {
                response.sendRedirect("products.jsp?msg=Producto no encontrado");
            }
        }

        if (request.getParameter("update")!=null) {
            int codigo_producto;
            double  precio_venta;
            String nombre_producto;

            codigo_producto = Integer.parseInt(request.getParameter("codigo_producto"));
            precio_venta = Double.parseDouble(request.getParameter("precio_venta"));
            nombre_producto = request.getParameter("nombre_producto");


            ProductosDTO productos = new ProductosDTO();
            productos.setCodigo_producto(codigo_producto);
            productos.setPrecio_venta(precio_venta);
            productos.setNombre_producto(nombre_producto);

            if (productosDAO.updateProducto(productos)) {
                response.sendRedirect("products.jsp?msg=Producto modificado");

            }else {
                response.sendRedirect("products.jsp?msg=error al modificar el producto");
            }

        }

        if (request.getParameter("upload")!=null) {
            Part archivo = request.getPart("archivo");
            String URL = "D:/Programacion Web/Proyecto Ciclo 3/Hardware-Store/src/main/webapp/documents/";
            //String URL = "../../webapp/documents"; Investigacion

            if(archivo.getContentType().equals("application/vnd.ms-excel")) {
                try {
                    InputStream file= archivo.getInputStream();
                    File copia= new File(URL + "productos.csv");
                    FileOutputStream escribir= new FileOutputStream(copia);
                    int num=file.read();
                    while(num !=-1) {
                        escribir.write(num);
                        num=file.read();
                    }
                    file.close();
                    escribir.close();
                    JOptionPane.showMessageDialog(null, "Se cargo el archivo correctamente");
                    if(productosDAO.uploadProducto(URL + "productos.csv")) {
                        response.sendRedirect("products.jsp?men=Registro de productos exitoso");
                    }else
                    {
                        response.sendRedirect("products.jsp?men=Carga fallida de archivo, por falla en nombre");
                    }
                }catch(Exception e) {
                    JOptionPane.showMessageDialog(null, "Carga fallida de archivo por error de" +
                            " formato: "+e);
                    response.sendRedirect("products.jsp?men=Carga fallida de archivo por error de validacion: ");

                }
            }else
            {
                response.sendRedirect("products.jsp?men=Formato de Archivo no permitido");
            }


        }
    }
}

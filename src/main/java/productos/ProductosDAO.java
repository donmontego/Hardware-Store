package productos;

import Conexion.Conexion;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductosDAO {

    Conexion conexion = new Conexion();
    Connection con = conexion.connect();
    PreparedStatement statement = null;
    ResultSet resultSet = null;

    public ProductosDTO searchProducto (int codigo_producto) {

        ProductosDTO producto =  null;

        try {
            String query = "Select * from productos where codigo_producto = ?";
            statement = con.prepareStatement(query);
            statement.setInt(1, codigo_producto);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                producto = new ProductosDTO(Integer.parseInt(resultSet.getString(1)),
                        Double.parseDouble(resultSet.getString(2)),
                        Double.parseDouble(resultSet.getString(5)),
                        Double.parseDouble(resultSet.getString(6)),
                        resultSet.getString(3),
                        resultSet.getString(4));
            }


        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Carga fallida del archivo" + e);
        }
        return producto;
    }

    public boolean updateProducto (ProductosDTO producto) {
        boolean result = false;

        try {
            String query = "update productos set nombre_producto = ?," +
                    "precio_venta = ? where codigo_producto = ?";
            statement = con.prepareStatement(query);
            statement.setString(1, producto.getNombre_producto());
            statement.setDouble(2, producto.getPrecio_venta());
            statement.setInt(3, producto.getCodigo_producto());
            result = statement.executeUpdate() > 0;

        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error" + e);
        }
        return result;
    }

    public boolean uploadProducto(String URL) {

        boolean result = false;

        try {
            String query1 = "DELETE FROM productos";
            statement = con.prepareStatement(query1);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Borrado");

            String query = "load data infile '"+URL+"' into table productos fields terminated by ','" +
                    " lines terminated by '\r\n'";

            statement = con.prepareStatement(query);
            result = statement.executeUpdate() > 0;

        }catch(SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al registrar los productos: "+ ex);
        }
        return result;
    }

}

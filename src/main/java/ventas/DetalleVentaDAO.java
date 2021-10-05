package ventas;

import Conexion.Conexion;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DetalleVentaDAO {
    Conexion conexion = new Conexion();
    Connection con = conexion.connect();
    PreparedStatement statement = null;
    ResultSet resultSet = null;

    public boolean insertDatalleVenta(DetalleVentaDTO detalleVentaDTO){
        boolean result = false;
        try{
           String query = "insert into detalle_venta (cantidad_producto,codigo_producto,codigo_venta,valor_total,valor_venta,valoriva) values(?,?,?,?,?,?)";
           statement = con.prepareStatement(query);
           statement.setInt(1,detalleVentaDTO.getCantidadProduto());
           statement.setInt(2,detalleVentaDTO.getCodigoProduto());
           statement.setInt(3,detalleVentaDTO.getCodigoVenta());
           statement.setDouble(4,detalleVentaDTO.getValorTotal());
           statement.setDouble(5,detalleVentaDTO.getValorVenta());
           statement.setDouble(6,detalleVentaDTO.getValorIva());
           result = statement.executeUpdate() > 0;
        }catch (SQLException e){
//            JOptionPane.showMessageDialog(null, e);
            System.out.println("error dtalle venta "+ e);
        }
        return result;
    }
}

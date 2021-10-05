package ventas;

import Conexion.Conexion;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VentasDAO {
    Conexion conexion = new Conexion();
    Connection con = conexion.connect();
    PreparedStatement statement = null;
    ResultSet resultSet = null;

    public int insertVenta(VentasDTO venta) {
        int codigoVenta = 0;

        try {
            String query = "insert into Ventas (cedula_cliente,cedula_usuario,ivaventa,total_venta,valor_venta) values(?,?,?,?,?)";
            statement = con.prepareStatement(query);
            statement.setInt(1, venta.getCedulaCliente());
            statement.setInt(2, venta.getCedulaUsuario());
            statement.setDouble(3, 0);
            statement.setDouble(4, 0);
            statement.setDouble(5, 0);
            statement.executeUpdate();

            query = "select LAST_INSERT_ID()";
            statement = con.prepareStatement(query);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                codigoVenta = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("error insert venta :" + e);
//            JOptionPane.showMessageDialog(null, e);
        }
        return codigoVenta;
    }

    public VentasDTO searchVenta(int codigoVenta){
        VentasDTO ventasDTO = null;
        try {
           String query = "Select * from Ventas where codigo_venta=?";
           statement = con.prepareStatement(query);
           statement.setInt(1,codigoVenta);
           resultSet = statement.executeQuery();

           while(resultSet.next()){
               ventasDTO = new VentasDTO(
                       resultSet.getInt(1),
                       resultSet.getInt(2),
                       resultSet.getInt(3),
                       resultSet.getDouble(4),
                       resultSet.getDouble(5),
                       resultSet.getDouble(6)
               );
           }

        }catch (SQLException e) {
            System.out.println("error buscando venta: "+e);
        }

        return ventasDTO;
    }

}

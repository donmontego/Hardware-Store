package proveedores;

import Conexion.Conexion;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProveedoresDAO {
    Conexion conexion = new Conexion();
    Connection con = conexion.connect();
    PreparedStatement statement = null;

    public boolean insertUser(ProveedoresDTO supplier){
        boolean result = false;
        try{
            String query = "insert into proveedores values(?,?,?,?,?)";
            statement = con.prepareStatement(query);
            statement.setInt(1,supplier.getNit());
            statement.setString(2, supplier.getCity());
            statement.setString(3, supplier.getAdress());
            statement.setString(4, supplier.getName());
            statement.setInt(5, supplier.getTelephono());
            result = statement.executeUpdate() > 0;

        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error"+e);
        }
        return result;
    }
}

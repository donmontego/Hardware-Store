package clientes;

import Conexion.Conexion;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClientesDAO {
    Conexion conexion = new Conexion();
    Connection con = conexion.connect();
    PreparedStatement statement = null;

    public boolean insertUser(ClientesDTO clients){
        boolean result = false;
        try{
            String query = "insert into clientes values(?,?,?,?,?)";
            statement = con.prepareStatement(query);
            statement.setInt(1,clients.getCedula());
            statement.setString(2, clients.getAdress());
            statement.setString(3, clients.getEmail());
            statement.setString(4, clients.getName());
            statement.setString(5, clients.getPhone());
            result = statement.executeUpdate() > 0;

        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error"+e);
        }
        return result;
    }
}

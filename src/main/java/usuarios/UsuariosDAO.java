package usuarios;

import Conexion.Conexion;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsuariosDAO {
    Conexion conexion = new Conexion();
    Connection con = conexion.connect();
    PreparedStatement statement = null;

   public boolean insertUser(UsuariosDTO usuario){
       boolean result = false;
       try{
           String query = "insert into usuarios values(?,?,?,?,?)";
           statement = con.prepareStatement(query);
           statement.setInt(1,usuario.getCedula());
           statement.setString(2, usuario.getEmail());
           statement.setString(3, usuario.getName());
           statement.setString(4, usuario.getPassword());
           statement.setString(5, usuario.getUser());
           result = statement.executeUpdate() > 0;

       }catch(SQLException e){
           JOptionPane.showMessageDialog(null, "Error"+e);
       }
       return result;
   }


}

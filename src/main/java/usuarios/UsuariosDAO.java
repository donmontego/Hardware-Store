package usuarios;

import Conexion.Conexion;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuariosDAO {
    Conexion conexion = new Conexion();
    Connection con = conexion.connect();
    PreparedStatement statement = null;
    ResultSet resultSet = null;

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

    public UsuariosDTO searchUser(int cedula) {
        UsuariosDTO user = null;
        try {
            String query = "select * from usuarios where cedula_usuario=?";
            statement = con.prepareStatement(query);
            statement.setInt(1,cedula);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                user = new UsuariosDTO(Integer.parseInt(resultSet.getString(1)),
                        resultSet.getString(5),
                        resultSet.getString(4),
                        resultSet.getString(3),
                        resultSet.getString(2));
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error"+e);
        }
        return user;
    }
    public boolean updateUser(UsuariosDTO usuariosDTO) {
        boolean result = false;
        try{
            String query = "update usuarios set email_usuario=?, nombre_usuario=?, password=?," +
                    "usuario=? where cedula_usuario=?";
            statement = con.prepareStatement(query);
            statement.setString(1, usuariosDTO.getEmail());
            statement.setString(2, usuariosDTO.getName());
            statement.setString(3, usuariosDTO.getPassword());
            statement.setString(4, usuariosDTO.getUser());
            statement.setInt(5,usuariosDTO.getCedula());
            result = statement.executeUpdate() > 0;

        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error"+e);
        }
        return result;
    }

    public boolean deleteUser(int cedula) {
        boolean result = false;
        try{
            String query = "delete FROM usuarios WHERE cedula_usuario=?";
            statement= con.prepareStatement(query);
            statement.setInt(1, cedula);
            result = statement.executeUpdate() > 0;
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error"+e);
        }
        return result;
    }
}

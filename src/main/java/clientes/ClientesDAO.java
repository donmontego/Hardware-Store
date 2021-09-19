package clientes;

import Conexion.Conexion;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientesDAO {
    Conexion conexion = new Conexion();
    Connection con = conexion.connect();
    PreparedStatement statement = null;
    ResultSet resultSet = null;

    public boolean insertclient(ClientesDTO clients){
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
    public ClientesDTO searchCliente(int cedula) {
        ClientesDTO cliente = null;
        try {
            String query = "select * from clientes where cedula_cliente=?";
            statement = con.prepareStatement(query);
            statement.setInt(1,cedula);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                cliente = new ClientesDTO(Integer.parseInt(resultSet.getString(1)),resultSet.getString(2),
                        resultSet.getString(3),resultSet.getString(4), resultSet.getString(5));

            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error"+e);
        }
        return cliente;
    }

    public boolean updateClient(ClientesDTO clientsDTO) {
        boolean result = false;
        try{
            String query = "update clientes set direcion_cliente=?, email_cliente=?, nombre_cliente=?," +
                    "telefono_clientes=? where cedula_cliente=?";
            statement = con.prepareStatement(query);
            statement.setString(1, clientsDTO.getAdress());
            statement.setString(2, clientsDTO.getEmail());
            statement.setString(3, clientsDTO.getName());
            statement.setString(4, clientsDTO.getPhone());
            statement.setInt(5,clientsDTO.getCedula());
            result = statement.executeUpdate() > 0;

        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error"+e);
        }
        return result;
    }


    public boolean deleteclient(int cedula) {
        boolean result = false;
        try{
            String query = "delete FROM clientes WHERE cedula_cliente=?";
            statement= con.prepareStatement(query);
            statement.setInt(1, cedula);
            result = statement.executeUpdate() > 0;
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error"+e);
        }
        return result;
    }

}

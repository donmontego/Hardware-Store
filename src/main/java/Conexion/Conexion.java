package Conexion;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    private final String BD = "T_Generica";
    private final String URL = "jdbc:mysql://localhost:3306/"+ BD;
    private final String USER = "root";
    private final String PASS = "";

    Connection con = null;

    public Connection connect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL,USER,PASS);
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error"+e);
        }
        return con;
    }
}

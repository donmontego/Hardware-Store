package Conexion;

import javax.swing.*;
import java.sql.*;
/*import java.sql.Connection;
import java.sql.DriverManager;*/

public class Conexion {
    private final String BD = "grupo_8_equipo1";
   /* private final String URL = "prestamosvf.czo3ixoe3xoe.us-east-1.rds.amazonaws.com/"+ BD;*/
    private final String URL = "jdbc:mariadb://prestamosvf.czo3ixoe3xoe.us-east-1.rds.amazonaws.com/"+ BD;
    private final String USER = "admin";
    private final String PASS = "Ciclo3_admi123";

    Connection conn = null;

    public Connection connect(){
        try{
            /*Class.forName("com.mysql.cj.jdbc.Driver");*/
            Class.forName("org.mariadb.jdbc.Driver");
            conn = DriverManager.getConnection(URL,USER,PASS);
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error"+e);
        }
        return conn;
    }
}

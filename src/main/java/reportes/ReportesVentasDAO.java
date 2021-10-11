package reportes;

import Conexion.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReportesVentasDAO {

    Conexion conexion = new Conexion();
    Connection con = conexion.connect();
    PreparedStatement statement = null;
    ResultSet resultSet = null;

    public ArrayList<ReportesVentasDTO> totalSales () {
        ReportesVentasDTO reportesVentasDTO = null;
        ArrayList<ReportesVentasDTO> listaSales = new ArrayList<>();

        try {
            String query = "Select c.cedula_cliente, c.nombre_cliente, sum(v.valor_venta)" +
                    "  FROM Clientes as c inner join Ventas as v on c.cedula_cliente = v.cedula_cliente" +
                    " group by v.cedula_cliente ";
            statement = con.prepareStatement(query);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                reportesVentasDTO = new ReportesVentasDTO(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getDouble(3)
                );
                listaSales.add(reportesVentasDTO);
            }

        }catch (SQLException e) {
            System.out.println(e);
        } return listaSales;
    }
}

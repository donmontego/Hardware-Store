package reportes;

public class ReportesVentasDTO {
    private int id;
    private String name;
    private double totalSales;

    public ReportesVentasDTO(int id, String name, double totalSales) {
        this.id = id;
        this.name = name;
        this.totalSales = totalSales;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(double totalSales) {
        this.totalSales = totalSales;
    }
}

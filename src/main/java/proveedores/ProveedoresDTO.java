package proveedores;

public class ProveedoresDTO {
    private int nit;
    private String city;
    private String adress;
    private String name;
    private int telephono;

    public ProveedoresDTO() {
    }

    public ProveedoresDTO(int nit, String city, String adress, String name, int telephono) {
        this.nit = nit;
        this.city = city;
        this.adress = adress;
        this.name = name;
        this.telephono = telephono;
    }

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTelephono() {
        return telephono;
    }

    public void setTelephono(int telephono) {
        this.telephono = telephono;
    }
}

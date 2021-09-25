package proveedores;

public class ProveedoresDTO {
    private String nit;
    private String name;
    private String address;
    private String phone;
    private String city;

    public ProveedoresDTO() {
    }

    public ProveedoresDTO(String nit, String name, String address, String phone, String city) {
        this.nit = nit;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.city = city;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}

package clientes;

public class ClientesDTO {
    private int cedula;
    private String adress;
    private String email;
    private String name;
    private String phone;

    public ClientesDTO() {
    }

    public ClientesDTO(int cedula, String address, String email, String name, String phone) {
        this.cedula = cedula;
        this.adress = address;
        this.email = email;
        this.name = name;
        this.phone = phone;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

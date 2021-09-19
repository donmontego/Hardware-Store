package clientes;

public class ClientesDTO {
    private int idC;
    private String adress;
    private String email;
    private String name;
    private int telephono;

    public ClientesDTO() {
    }

    public ClientesDTO(int cedula, String direction, String email, String name, int telefono) {
        this.idC = cedula;
        this.adress = direction;
        this.email = email;
        this.name = name;
        this.telephono = telefono;
    }

    public int getIdC() {
        return idC;
    }

    public void setIdC(int idC) {
        this.idC = idC;
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

    public int getTelephono() {
        return telephono;
    }

    public void setTelephono(int telephono) {
        this.telephono = telephono;
    }
}

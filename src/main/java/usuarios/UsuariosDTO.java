package usuarios;

public class UsuariosDTO {
    private int cedula;
    private String user;
    private String password;
    private String name;
    private String email;

    public UsuariosDTO() {
    }

    public UsuariosDTO(int cedula, String user, String password, String name, String email) {
        this.cedula = cedula;
        this.user = user;
        this.password = password;
        this.name = name;
        this.email = email;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

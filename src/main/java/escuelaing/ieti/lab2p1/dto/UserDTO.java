package escuelaing.ieti.lab2p1.dto;

public class UserDTO {

    private String name;
    public String email;
    private String lastName;
    private String createdAt;
    private String password;

    public UserDTO(String name, String email, String lastName, String createdAt, String password) {
        this.name = name;
        this.email = email;
        this.lastName = lastName;
        this.createdAt = createdAt;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

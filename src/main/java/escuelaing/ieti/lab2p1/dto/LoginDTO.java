package escuelaing.ieti.lab2p1.dto;

public class LoginDTO {
    public String email;

    public String password;

    public LoginDTO( String email, String password )
    {
        this.email = email;
        this.password = password;
    }

    public String getEmail()
    {
        return email;
    }

    public String getPassword()
    {
        return password;
    }
}

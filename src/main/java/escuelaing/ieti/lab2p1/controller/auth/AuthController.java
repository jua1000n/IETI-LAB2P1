package escuelaing.ieti.lab2p1.controller.auth;

import escuelaing.ieti.lab2p1.dto.LoginDTO;
import escuelaing.ieti.lab2p1.dto.TokenDTO;
import escuelaing.ieti.lab2p1.entities.User;
import escuelaing.ieti.lab2p1.exception.InvalidCredentialsException;
import escuelaing.ieti.lab2p1.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.Date;

import static escuelaing.ieti.lab2p1.utils.Constants.CLAIMS_ROLES_KEY;
import static escuelaing.ieti.lab2p1.utils.Constants.TOKEN_DURATION_MINUTES;


@RestController
@RequestMapping( "v1/auth" )
public class AuthController
{

    @Value("${app.secret}")
    String secret;

    private UserService userService;
    public AuthController(@Autowired UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public TokenDTO login(@RequestBody LoginDTO loginDto )
    {
        User user = userService.findByEmail(loginDto.email);
        System.out.println(user.getEmail());
        System.out.println(loginDto.getPassword());
        if (BCrypt.checkpw(loginDto.password, user.getPasswordHash()))
        {
            return generateTokenDto(user);
        }
        else
        {
            throw new InvalidCredentialsException();
        }

    }

    private String generateToken(User user, Date expirationDate) {
        return Jwts.builder()
                .setSubject(user.getId())
                .claim(CLAIMS_ROLES_KEY, user.getRoles())
                .setIssuedAt(new Date())
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    private TokenDTO generateTokenDto(User user) {
        Calendar expirationDate = Calendar.getInstance();
        expirationDate.add(Calendar.MINUTE, TOKEN_DURATION_MINUTES);
        String token = generateToken(user, expirationDate.getTime());
        return new TokenDTO(token, expirationDate.getTime());
    }
}

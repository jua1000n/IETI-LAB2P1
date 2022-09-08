package escuelaing.ieti.lab2p1.exception;

import escuelaing.ieti.lab2p1.dto.ServerErrorResponseDTO;
import escuelaing.ieti.lab2p1.utils.ErrorCodeEnum;
import org.springframework.http.HttpStatus;

import javax.ws.rs.InternalServerErrorException;

public class InvalidCredentialsException extends InternalServerErrorException
{
    public InvalidCredentialsException() {
        super();
        new ServerErrorResponseDTO("User not found", ErrorCodeEnum.USER_NOT_FOUND, HttpStatus.NOT_FOUND);

    }
}

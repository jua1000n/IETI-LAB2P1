package escuelaing.ieti.lab2p1.dto;

import escuelaing.ieti.lab2p1.utils.ErrorCodeEnum;
import org.springframework.http.HttpStatus;

public class ServerErrorResponseDTO {
    String message;
    ErrorCodeEnum errorCode;
    int httpStatus;

    public ServerErrorResponseDTO(String message, ErrorCodeEnum errorCode, HttpStatus httpStatus) {
        this.message = message;
        this.errorCode = errorCode;
        this.httpStatus = httpStatus.value();
    }
    public String  getMessage() {
        return message;
    }

    public ErrorCodeEnum  getErrorCode() {
        return errorCode;
    }

    public int getHttpStatus() {
        return httpStatus;
    }
}

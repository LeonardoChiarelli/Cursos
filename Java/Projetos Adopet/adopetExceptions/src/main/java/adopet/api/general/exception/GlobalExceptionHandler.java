package adopet.api.general.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ValidacaoException.class)
    public ResponseEntity<ResponseError> validacaoException(ValidacaoException e) {
        // Aqui você pode personalizar a mensagem de erro, caso necessário

        var response = new ResponseError(e.getMessage(), HttpStatus.BAD_REQUEST, LocalDateTime.now());

        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseError> generalException(Exception e){

        var response = new ResponseError(e.getMessage(), HttpStatus.BAD_REQUEST, LocalDateTime.now());

        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ResponseError> nullPointerError(Exception e){

        var response = new ResponseError(e.getMessage(), HttpStatus.BAD_REQUEST, LocalDateTime.now());

        return ResponseEntity.badRequest().body(response);
    }
}

package br.com.LeoChiarelli.adopet.api.general.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ValidacaoException.class)
    public ResponseEntity<String> handleValidacaoException(ValidacaoException ex) {
        // Aqui você pode personalizar a mensagem de erro, caso necessário
        return new ResponseEntity<>("Id inválido", HttpStatus.NOT_FOUND);
    }
}

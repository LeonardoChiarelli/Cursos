package br.com.LeoChiarelli.api.general.infra.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.naming.AuthenticationException;
import java.nio.file.AccessDeniedException;

@RestControllerAdvice // Para indicar ao spring que é uma classe que vai tratar erros
public class ErrorHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity treatError404(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity treatError400(MethodArgumentNotValidException ex){
        var erros = ex.getFieldErrors();

        return ResponseEntity.badRequest().body(erros.stream().map(validationErrorsData::new).toList());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity treatError400(HttpMessageNotReadableException ex){
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity treatBadCredentialError(){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais Inválidas");
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity treatAuthenticationError(){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Falha na autenticação");
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity treatAccessDeniedError(){
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Acesso Negado");
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity treatError500(Exception ex){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro: " + ex.getLocalizedMessage());
    }

    private record validationErrorsData(String campo, String mensagem){

        public validationErrorsData(FieldError ex){
            this(ex.getField(), ex.getDefaultMessage());
        }
    }
}

// Erro 400 - indica que o servidor não conseguiu procesar uma requisão por erro de validação nos dados enviados pelo cliente

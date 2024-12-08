package br.com.LeoChiarelli.api.general.infra.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

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

    private record validationErrorsData(String campo, String mensagem){

        public validationErrorsData(FieldError ex){
            this(ex.getField(), ex.getDefaultMessage());
        }
    }
}

// Erro 400 - indica que o servidor não conseguiu procesar uma requisão por erro de validação nos dados enviados pelo cliente

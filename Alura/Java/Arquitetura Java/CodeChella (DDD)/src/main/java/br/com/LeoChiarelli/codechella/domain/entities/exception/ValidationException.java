package br.com.LeoChiarelli.codechella.domain.entities.exception;

public class ValidationException extends RuntimeException {
    public ValidationException(String mensagem) {
        super(mensagem);
    }
}

package br.com.LeoChiarelli.codechellaDDD.application;

public class ValidationException extends RuntimeException {
    public ValidationException(String mensagem) {
        super(mensagem);
    }
}

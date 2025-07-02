package br.com.LeoChiarelli.codechellaAPI.domain.email;

public interface EmailSender {

    void send(String recipient, String subject, String message);

}

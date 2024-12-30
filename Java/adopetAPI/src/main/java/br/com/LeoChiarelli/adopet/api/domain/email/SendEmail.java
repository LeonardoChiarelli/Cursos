package br.com.LeoChiarelli.adopet.api.domain.email;

public interface SendEmail {

    void enviarEmail(String to, String subject, String message);

}

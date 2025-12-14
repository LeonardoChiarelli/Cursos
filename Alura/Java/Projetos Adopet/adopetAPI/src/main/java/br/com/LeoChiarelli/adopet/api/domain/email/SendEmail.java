package br.com.LeoChiarelli.adopet.api.domain.email;

import org.springframework.scheduling.annotation.Async;

public interface SendEmail {

    @Async
    void enviarEmail(String to, String subject, String message);

}

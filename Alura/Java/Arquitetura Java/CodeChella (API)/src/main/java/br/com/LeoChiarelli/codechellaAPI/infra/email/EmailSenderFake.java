package br.com.LeoChiarelli.codechellaAPI.infra.email;

import br.com.LeoChiarelli.codechellaAPI.domain.email.EmailSender;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@Profile("default")
public class EmailSenderFake implements EmailSender {

    @Async
    public void send(String recipient, String subject, String message) {
        System.out.println("===== Simulando envio de email =====");
        System.out.println("Destinatario: " + recipient);
        System.out.println("Assunto: " + subject);
        System.out.println("Mensagem: " + message);
    }

}

package br.com.LeoChiarelli.adopet.api.domain.email;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("default")
public class EmailDev implements SendEmail{

    @Override
    public void enviarEmail(String to, String subject, String message) {
        System.out.printf("""
                ------ Email fake ------
                Destinatário: %s
                Assunto: %s
                Mensagem: %s
                """, to, subject, message);
    }

}

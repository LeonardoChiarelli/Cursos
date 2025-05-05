package br.com.LeoChiarelli.adopet.api.domain.service;

import br.com.LeoChiarelli.adopet.api.domain.dto.PetDTO;
import br.com.LeoChiarelli.adopet.api.domain.email.SendEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchedulingService {

    @Autowired
    private PetService service;

    @Autowired
    private SendEmail email;

    @Scheduled(cron = "0 0 1 * * *")
    public void agendarRelatorioPets() {
        List<PetDTO> pets = service.listarTodosDisponiveis();
        email.enviarEmail(
                "admin@email.com",
                "Pets não adotados",
                """
                        Segue a lista de pets disponíveis para a adoção:
                        
                        %s
                        """.formatted(pets)
        );
        System.out.println(pets);
    }
}

package br.com.LeoChiarelli.adopet.api.service;

import br.com.LeoChiarelli.adopet.api.dto.AprovarAdocaoDTO;
import br.com.LeoChiarelli.adopet.api.dto.ReprovarAdocaoDTO;
import br.com.LeoChiarelli.adopet.api.dto.SolicitarAdocaoDTO;
import br.com.LeoChiarelli.adopet.api.email.SendEmail;
import br.com.LeoChiarelli.adopet.api.exception.ValidacaoException;
import br.com.LeoChiarelli.adopet.api.model.Adocao;
import br.com.LeoChiarelli.adopet.api.model.StatusAdocao;
import br.com.LeoChiarelli.adopet.api.repository.AdocaoRepository;
import br.com.LeoChiarelli.adopet.api.repository.PetRepository;
import br.com.LeoChiarelli.adopet.api.repository.TutorRepository;
import br.com.LeoChiarelli.adopet.api.strategy.IStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class AdocaoService {

    @Autowired
    private AdocaoRepository repository;

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private TutorRepository tutorRepository;

    @Autowired
    private SendEmail sendEmail;

    public void solicitar(SolicitarAdocaoDTO dto){
        var pet = petRepository.getReferenceById(dto.idPet());
        var tutor = tutorRepository.getReferenceById(dto.idTutor());



        var adocao = new Adocao();
        adocao.setData(LocalDateTime.now());
        adocao.setStatus(StatusAdocao.AGUARDANDO_AVALIACAO);
        adocao.setPet(pet);
        adocao.setTutor(tutor);
        adocao.setMotivo(dto.motivo());
        repository.save(adocao);

        sendEmail.enviarEmail(pet.getAbrigo().getEmail(),
                "Solicitação de adoção",
                "Olá " +pet.getAbrigo().getNome() +"!\n\nUma solicitação de adoção foi registrada hoje para o pet: " +adocao.getPet().getNome() +". \nFavor avaliar para aprovação ou reprovação.");
    }

    public void aprovar(AprovarAdocaoDTO dto){

        var adocao = repository.getReferenceById(dto.idAdocao());
        adocao.setStatus(StatusAdocao.APROVADO);
        // repository.save(adocao);

        sendEmail.enviarEmail(adocao.getTutor().getEmail(),
                "Adoção aprovada",
                "Parabéns " + adocao.getTutor().getNome() + "!\n\nSua adoção do pet " + adocao.getPet().getNome() + ", solicitada em " + adocao.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) + ", foi aprovada.\nFavor entrar em contato com o abrigo " + adocao.getPet().getAbrigo().getNome() + " para agendar a busca do seu pet.");
    }

    public void reprovar(ReprovarAdocaoDTO dto){

        var adocao = repository.getReferenceById(dto.idAdocao());
        adocao.setStatus(StatusAdocao.REPROVADO);
        adocao.setJustificativaStatus(dto.justificativa());
        // repository.save(adocao);

        sendEmail.enviarEmail(adocao.getTutor().getEmail(),
                "Adoção reprovada",
                "Olá " +adocao.getTutor().getNome() +"!\n\nInfelizmente sua adoção do pet " +adocao.getPet().getNome() +", solicitada em " +adocao.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) +", foi reprovada pelo abrigo " +adocao.getPet().getAbrigo().getNome() +" com a seguinte justificativa: " +adocao.getJustificativaStatus());
    }
}


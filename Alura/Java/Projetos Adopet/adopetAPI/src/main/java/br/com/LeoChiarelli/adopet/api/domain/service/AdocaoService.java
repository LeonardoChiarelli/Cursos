package br.com.LeoChiarelli.adopet.api.domain.service;

import br.com.LeoChiarelli.adopet.api.domain.dto.AprovarAdocaoDTO;
import br.com.LeoChiarelli.adopet.api.domain.dto.ReprovarAdocaoDTO;
import br.com.LeoChiarelli.adopet.api.domain.dto.SolicitarAdocaoDTO;
import br.com.LeoChiarelli.adopet.api.domain.email.SendEmail;
import br.com.LeoChiarelli.adopet.api.domain.model.Adocao;
import br.com.LeoChiarelli.adopet.api.domain.repository.IAdocaoRepository;
import br.com.LeoChiarelli.adopet.api.domain.repository.IPetRepository;
import br.com.LeoChiarelli.adopet.api.domain.repository.ITutorRepository;
import br.com.LeoChiarelli.adopet.api.general.strategy.IStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class AdocaoService {

    @Autowired
    private IAdocaoRepository repository;

    @Autowired
    private IPetRepository petRepository;

    @Autowired
    private ITutorRepository tutorRepository;

    @Autowired
    private SendEmail sendEmail;

    @Autowired
    private List<IStrategy> validacoes;

    public void solicitar(SolicitarAdocaoDTO dto){
        var pet = petRepository.getReferenceById(dto.idPet());
        var tutor = tutorRepository.getReferenceById(dto.idTutor());

        validacoes.forEach(v-> v.validar(dto));

        var adocao = new Adocao(pet, tutor, dto.motivo());
        repository.save(adocao);

        sendEmail.enviarEmail(pet.getAbrigo().getEmail(),
                "Solicitação de adoção",
                "Olá " +pet.getAbrigo().getNome() +"!\n\nUma solicitação de adoção foi registrada hoje para o pet: " +adocao.getPet().getNome() +". \nFavor avaliar para aprovação ou reprovação.");
    }

    public void aprovar(AprovarAdocaoDTO dto){

        var adocao = repository.getReferenceById(dto.idAdocao());
        adocao.mudarStatusAprovado();
        // repository.save(adocao);

        sendEmail.enviarEmail(adocao.getTutor().getEmail(),
                "Adoção aprovada",
                "Parabéns " + adocao.getTutor().getNome() + "!\n\nSua adoção do pet " + adocao.getPet().getNome() + ", solicitada em " + adocao.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) + ", foi aprovada.\nFavor entrar em contato com o abrigo " + adocao.getPet().getAbrigo().getNome() + " para agendar a busca do seu pet.");
    }

    public void reprovar(ReprovarAdocaoDTO dto){

        var adocao = repository.getReferenceById(dto.idAdocao());
        adocao.mudarStatusReprovado();
        adocao.receberJustificativa(dto.justificativa());
        // repository.save(adocao);

        sendEmail.enviarEmail(adocao.getTutor().getEmail(),
                "Adoção reprovada",
                "Olá " +adocao.getTutor().getNome() +"!\n\nInfelizmente sua adoção do pet " +adocao.getPet().getNome() +", solicitada em " +adocao.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) +", foi reprovada pelo abrigo " +adocao.getPet().getAbrigo().getNome() +" com a seguinte justificativa: " +adocao.getJustificativaStatus());
    }
}


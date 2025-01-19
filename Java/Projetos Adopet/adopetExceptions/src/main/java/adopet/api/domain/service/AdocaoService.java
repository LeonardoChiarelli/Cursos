package adopet.api.domain.service;

import adopet.api.domain.dto.AdocaoDTO;
import adopet.api.domain.dto.AprovarAdocaoDTO;
import adopet.api.domain.dto.ReprovarAdocaoDTO;
import adopet.api.domain.dto.SolicitacaoDeAdocaoDTO;
import adopet.api.domain.model.Adocao;
import adopet.api.domain.model.Pet;
import adopet.api.domain.model.Tutor;
import adopet.api.domain.repository.IAdocaoRepository;
import adopet.api.domain.repository.IPetRepository;
import adopet.api.domain.repository.ITutorRepository;
import adopet.api.general.strategy.IStrategy;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdocaoService {

    @Autowired
    private IPetRepository petRepository;

    @Autowired
    private ITutorRepository tutorRepository;

    @Autowired
    private IAdocaoRepository adocaoRepository;

    @Autowired
    private List<IStrategy> strategies;

    public List<AdocaoDTO> listarTodos(){
        return adocaoRepository.findAll().stream().map(AdocaoDTO::new).toList();
    }

    public AdocaoDTO listar(Long id){
        return adocaoRepository.findById(id).stream().findFirst().map(AdocaoDTO::new).orElse(null);
    }

    public void solicitar(SolicitacaoDeAdocaoDTO dto){
        Pet pet = petRepository.getReferenceById(dto.idPet());
        Tutor tutor = tutorRepository.getReferenceById(dto.idTutor());

        strategies.forEach(s -> s.validar(dto));

        adocaoRepository.save(new Adocao(tutor,pet, dto.motivo()));
    }

    public void aprovar(AprovarAdocaoDTO dto){
        Adocao adocao = adocaoRepository.getReferenceById(dto.idAdocao());
        adocao.marcarComoAprovada();
        adocao.getPet().marcarComoAdotado();
    }

    public void reprovar(ReprovarAdocaoDTO dto){
        Adocao adocao = adocaoRepository.getReferenceById(dto.idAdocao());
        adocao.marcarComoReprovada(dto.justificativa());
    }
}

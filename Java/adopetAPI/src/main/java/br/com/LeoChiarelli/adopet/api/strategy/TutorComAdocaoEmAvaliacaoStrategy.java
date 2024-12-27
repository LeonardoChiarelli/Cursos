package br.com.LeoChiarelli.adopet.api.strategy;

import br.com.LeoChiarelli.adopet.api.dto.SolicitarAdocaoDTO;
import br.com.LeoChiarelli.adopet.api.exception.ValidacaoException;
import br.com.LeoChiarelli.adopet.api.model.Adocao;
import br.com.LeoChiarelli.adopet.api.model.StatusAdocao;
import br.com.LeoChiarelli.adopet.api.repository.AdocaoRepository;
import br.com.LeoChiarelli.adopet.api.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TutorComAdocaoEmAvaliacaoStrategy implements IStrategy{

    @Autowired
    private TutorRepository repository;

    @Autowired
    private AdocaoRepository adocaoRepository;

    public void validar(SolicitarAdocaoDTO dto){
        var tutor = repository.getReferenceById(dto.idTutor());

        List<Adocao> adocoes = adocaoRepository.findAll();
        for (Adocao a : adocoes) {
            if (a.getTutor() == tutor && a.getStatus() == StatusAdocao.AGUARDANDO_AVALIACAO) {
                throw new ValidacaoException("Tutor já possui outra adoção aguardando avaliação!");
            }
        }
    }
}

package br.com.LeoChiarelli.adopet.api.general.strategy;

import br.com.LeoChiarelli.adopet.api.domain.dto.SolicitarAdocaoDTO;
import br.com.LeoChiarelli.adopet.api.domain.model.Adocao;
import br.com.LeoChiarelli.adopet.api.domain.model.StatusAdocao;
import br.com.LeoChiarelli.adopet.api.domain.repository.IAdocaoRepository;
import br.com.LeoChiarelli.adopet.api.domain.repository.ITutorRepository;
import br.com.LeoChiarelli.adopet.api.general.exception.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TutorComLimiteDeAdocoesStrategy implements IStrategy{

    @Autowired
    private IAdocaoRepository adocaoRepository;

    @Autowired
    private ITutorRepository tutorRepository;

    public void validar(SolicitarAdocaoDTO dto){

        List<Adocao> listaAdoces = adocaoRepository.findAll();
        var tutor = tutorRepository.getReferenceById(dto.idTutor());

        int contador = 0;
        for (Adocao a : listaAdoces) {
            if (a.getTutor() == tutor && a.getStatus() == StatusAdocao.APROVADO) { contador += 1; }
            if (contador == 5) { throw new ValidacaoException("Tutor chegou ao limite máximo de 5 adoções!"); }
        }
    }
}

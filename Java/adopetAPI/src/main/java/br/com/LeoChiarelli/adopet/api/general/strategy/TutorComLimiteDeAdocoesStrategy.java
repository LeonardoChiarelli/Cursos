package br.com.LeoChiarelli.adopet.api.general.strategy;

import br.com.LeoChiarelli.adopet.api.domain.dto.SolicitarAdocaoDTO;
import br.com.LeoChiarelli.adopet.api.domain.model.Adocao;
import br.com.LeoChiarelli.adopet.api.domain.model.StatusAdocao;
import br.com.LeoChiarelli.adopet.api.domain.repository.IAdocaoRepository;
import br.com.LeoChiarelli.adopet.api.general.exception.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TutorComLimiteDeAdocoesStrategy implements IStrategy{

    @Autowired
    private IAdocaoRepository adocaoRepository;

    public void validar(SolicitarAdocaoDTO dto){

        var statusTutor = adocaoRepository.existsByTutorIdAndStatus(dto.idTutor(), StatusAdocao.APROVADO);
        var listaAdoces = adocaoRepository.findByTutorId(dto.idTutor());

        for (Adocao a : listaAdoces) {
            int contador = 0;
            if (statusTutor) { contador += 1; }
            if (contador == 5) { throw new ValidacaoException("Tutor chegou ao limite máximo de 5 adoções!"); }
        }
    }
}

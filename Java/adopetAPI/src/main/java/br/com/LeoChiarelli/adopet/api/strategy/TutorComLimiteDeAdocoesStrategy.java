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
public class TutorComLimiteDeAdocoesStrategy implements IStrategy{

    @Autowired
    private TutorRepository repository;

    @Autowired
    private AdocaoRepository adocaoRepository;

    public void validar(SolicitarAdocaoDTO dto){
        List<Adocao> adocoes = adocaoRepository.findAll();
        var tutor = repository.getReferenceById(dto.idTutor());

        for (Adocao a : adocoes) {
            int contador = 0;
            if (a.getTutor() == tutor && a.getStatus() == StatusAdocao.APROVADO) {
                contador += 1;
            }
            if (contador == 5) {
                throw new ValidacaoException("Tutor chegou ao limite máximo de 5 adoções!");
            }
        }
    }

}

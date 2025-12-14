package adopet.api.general.strategy;

import adopet.api.domain.dto.SolicitacaoDeAdocaoDTO;
import adopet.api.domain.model.StatusAdocao;
import adopet.api.domain.repository.IAdocaoRepository;
import adopet.api.general.exception.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TutorCom2AdocoesAprovadas implements IStrategy{

    @Autowired
    private IAdocaoRepository repository;

    @Override
    public void validar(SolicitacaoDeAdocaoDTO dto) {

        var tutor = repository.countByTutorIdAndStatus(dto.idTutor(), StatusAdocao.APROVADO);

        if (tutor >= 2) { throw new ValidacaoException("Tutor chegou ao limite de 2 adoções aprovadas"); }
    }
}

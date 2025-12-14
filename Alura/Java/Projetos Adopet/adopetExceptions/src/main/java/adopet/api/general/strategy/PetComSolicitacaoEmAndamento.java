package adopet.api.general.strategy;

import adopet.api.domain.dto.SolicitacaoDeAdocaoDTO;
import adopet.api.domain.model.StatusAdocao;
import adopet.api.domain.repository.IAdocaoRepository;
import adopet.api.general.exception.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PetComSolicitacaoEmAndamento implements IStrategy{

    @Autowired
    private IAdocaoRepository repository;

    @Override
    public void validar(SolicitacaoDeAdocaoDTO dto) {

        var statusPet = repository.existsByPetIdAndStatus(dto.idPet(), StatusAdocao.AGUARDANDO_AVALIACAO);

        if (statusPet) {throw new ValidacaoException("O pet já tem uma solicitação em andamento"); }
    }
}

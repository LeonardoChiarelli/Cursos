package adopet.api.general.strategy;

import adopet.api.domain.dto.SolicitacaoDeAdocaoDTO;
import adopet.api.domain.repository.IPetRepository;
import adopet.api.general.exception.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PetJaAdotado implements IStrategy{

    @Autowired
    private IPetRepository repository;

    @Override
    public void validar(SolicitacaoDeAdocaoDTO dto) {
        var statusPet = repository.getReferenceById(dto.idPet());

        if (statusPet.getAdotado()){ throw new ValidacaoException("Pet já adotoado!");}
    }
}

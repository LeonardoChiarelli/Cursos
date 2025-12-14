package br.com.LeoChiarelli.adopet.api.general.strategy;

import br.com.LeoChiarelli.adopet.api.domain.dto.SolicitarAdocaoDTO;
import br.com.LeoChiarelli.adopet.api.general.exception.ValidacaoException;
import br.com.LeoChiarelli.adopet.api.domain.repository.IPetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PetDisponivelStrategy implements IStrategy{

    @Autowired
    private IPetRepository repository;

    public void validar(SolicitarAdocaoDTO dto) {
        var pet = repository.
                getReferenceById(dto.idPet());
        if (pet.getAdotado()) {throw new ValidacaoException("Pet já foi adotado!");}
    }
}

package br.com.LeoChiarelli.adopet.api.strategy;

import br.com.LeoChiarelli.adopet.api.dto.SolicitarAdocaoDTO;
import br.com.LeoChiarelli.adopet.api.exception.ValidacaoException;
import br.com.LeoChiarelli.adopet.api.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PetDisponivelStrategy implements IStrategy{

    @Autowired
    private PetRepository repository;

    public void validar(SolicitarAdocaoDTO dto) {
        var pet = repository.getReferenceById(dto.idPet());
        if (pet.getAdotado()) {
            throw new ValidacaoException("Pet já foi adotado!");
        }
    }
}

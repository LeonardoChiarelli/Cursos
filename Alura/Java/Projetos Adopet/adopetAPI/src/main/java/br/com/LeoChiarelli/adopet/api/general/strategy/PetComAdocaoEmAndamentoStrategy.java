package br.com.LeoChiarelli.adopet.api.general.strategy;

import br.com.LeoChiarelli.adopet.api.domain.dto.SolicitarAdocaoDTO;
import br.com.LeoChiarelli.adopet.api.domain.model.StatusAdocao;
import br.com.LeoChiarelli.adopet.api.domain.repository.IAdocaoRepository;
import br.com.LeoChiarelli.adopet.api.general.exception.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PetComAdocaoEmAndamentoStrategy implements IStrategy{

    @Autowired
    private IAdocaoRepository adocaoRepository;

    public void validar(SolicitarAdocaoDTO dto){
        var statusPet = adocaoRepository
                .existsByPetIdAndStatus(dto.idPet(), StatusAdocao.AGUARDANDO_AVALIACAO);

        if (statusPet) {throw new ValidacaoException("Pet já está aguardando avaliação para ser adotado!");}
    }
}

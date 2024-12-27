package br.com.LeoChiarelli.adopet.api.strategy;

import br.com.LeoChiarelli.adopet.api.dto.SolicitarAdocaoDTO;
import br.com.LeoChiarelli.adopet.api.exception.ValidacaoException;
import br.com.LeoChiarelli.adopet.api.model.Adocao;
import br.com.LeoChiarelli.adopet.api.model.StatusAdocao;
import br.com.LeoChiarelli.adopet.api.repository.AdocaoRepository;
import br.com.LeoChiarelli.adopet.api.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PetComAdocaoEmAndamentoStrategy implements IStrategy{

    @Autowired
    private PetRepository repository;

    @Autowired
    private AdocaoRepository adocaoRepository;

    public void validar(SolicitarAdocaoDTO dto){
        List<Adocao> adocoes = adocaoRepository.findAll();
        var pet = repository.getReferenceById(dto.idPet());

        for (Adocao a : adocoes) {
            if (a.getPet() == pet && a.getStatus() == StatusAdocao.AGUARDANDO_AVALIACAO) {
                throw new ValidacaoException("Pet já está aguardando avaliação para ser adotado!");
            }
        }
    }
}

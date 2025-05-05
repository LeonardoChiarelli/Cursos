package br.com.LeoChiarelli.adopet.api.domain.service;

import br.com.LeoChiarelli.adopet.api.domain.dto.CadastrarPetDTO;
import br.com.LeoChiarelli.adopet.api.domain.dto.PetDTO;
import br.com.LeoChiarelli.adopet.api.domain.model.Abrigo;
import br.com.LeoChiarelli.adopet.api.domain.model.Pet;
import br.com.LeoChiarelli.adopet.api.domain.repository.IPetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

    @Autowired
    private IPetRepository  repository;

    public List<PetDTO> listarTodosDisponiveis(){
        return repository
                .findAllByAdotadoFalse()
                .stream()
                .map(PetDTO::new)
                .toList();
    }

    public void cadastrarPet(Abrigo abrigo, CadastrarPetDTO dto){
        repository.save(new Pet(dto, abrigo));
    }
}
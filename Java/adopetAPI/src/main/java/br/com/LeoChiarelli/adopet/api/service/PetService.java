package br.com.LeoChiarelli.adopet.api.service;

import br.com.LeoChiarelli.adopet.api.model.Pet;
import br.com.LeoChiarelli.adopet.api.repository.PetRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PetService {

    protected PetRepository repository;

    public List<Pet> listarTodosDisponiveis(){
        List<Pet> pets = repository.findAll();
        List<Pet> disponiveis = new ArrayList<>();
        for (Pet pet : pets) {
            if (!pet.getAdotado()) {
                disponiveis.add(pet);
            }
        }
        return disponiveis;
    }
}

package br.com.LeoChiarelli.adopet.api.service;

import br.com.LeoChiarelli.adopet.api.dto.CadastrarAbrigoDTO;
import br.com.LeoChiarelli.adopet.api.exception.ValidacaoException;
import br.com.LeoChiarelli.adopet.api.model.Abrigo;
import br.com.LeoChiarelli.adopet.api.model.Pet;
import br.com.LeoChiarelli.adopet.api.repository.AbrigoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AbrigoService {

    @Autowired
    AbrigoRepository repository;

    public List<Abrigo> listar(){
        return repository.findAll();
    }

    public void cadastrar(CadastrarAbrigoDTO dto){

        var abrigo = repository.getReferenceById(dto.id());

        boolean nomeJaCadastrado = repository.existsByNome(abrigo.getNome());
        boolean telefoneJaCadastrado = repository.existsByTelefone(abrigo.getTelefone());
        boolean emailJaCadastrado = repository.existsByEmail(abrigo.getEmail());

        if (nomeJaCadastrado || telefoneJaCadastrado || emailJaCadastrado) {
            throw new ValidacaoException("Dados já cadastrados para outro abrigo!");
        } else {
            repository.save(abrigo);
        }
    }

    public List<Pet> listarPets(String idOuNome){
        try {
            Long id = Long.parseLong(idOuNome);
            return repository.getReferenceById(id).getPets();
        } catch (NumberFormatException e) {
            return repository.findByNome(idOuNome).getPets();
        }
    }

    public void cadastrarPet(String idOuNome, Pet pet){
        try {
            Long id = Long.parseLong(idOuNome);
            Abrigo abrigo = repository.getReferenceById(id);
            pet.setAbrigo(abrigo);
            pet.setAdotado(false);
            abrigo.getPets().add(pet);
            repository.save(abrigo);
        } catch (NumberFormatException nfe) {
            Abrigo abrigo = repository.findByNome(idOuNome);
            pet.setAbrigo(abrigo);
            pet.setAdotado(false);
            abrigo.getPets().add(pet);
            repository.save(abrigo);
        }
    }
}

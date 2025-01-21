package br.com.LeoChiarelli.adopet.api.domain.service;

import br.com.LeoChiarelli.adopet.api.domain.dto.AbrigoDTO;
import br.com.LeoChiarelli.adopet.api.domain.dto.CadastrarAbrigoDTO;
import br.com.LeoChiarelli.adopet.api.domain.dto.PetDTO;
import br.com.LeoChiarelli.adopet.api.domain.model.Abrigo;
import br.com.LeoChiarelli.adopet.api.domain.repository.IAbrigoRepository;
import br.com.LeoChiarelli.adopet.api.domain.repository.IPetRepository;
import br.com.LeoChiarelli.adopet.api.general.exception.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AbrigoService {

    @Autowired
    private IAbrigoRepository repository;

    @Autowired
    private IPetRepository petRepository;

    public List<AbrigoDTO> listar(){
        return repository.
                findAll()
                .stream()
                .map(AbrigoDTO::new)
                .toList();
    }

    public void cadastrar(CadastrarAbrigoDTO dto){

        boolean jaCadastrado = repository.existsByNomeOrTelefoneOrEmail(dto.nome(), dto.telefone(), dto.email());

        if (jaCadastrado) { throw new ValidacaoException("Dados já cadastrados para outro abrigo!"); }

        repository.save(new Abrigo(dto));
    }

    public List<PetDTO> listarPets(String idOuNome){
        var abrigo = carregarAbrigo(idOuNome);

        return petRepository
                .findByAbrigo(abrigo)
                .stream()
                .map(PetDTO::new)
                .toList();
    }

    public Abrigo carregarAbrigo(String idOuNome) {
        Optional<Abrigo> optional;
        try {
            Long id = Long.parseLong(idOuNome);
            optional = repository.findById(id);
        } catch (NumberFormatException exception) {
            optional = Optional.ofNullable(repository.findByNome(idOuNome));
        }

        return optional.orElseThrow(() -> new ValidacaoException("Abrigo não encontrado"));
    }
}

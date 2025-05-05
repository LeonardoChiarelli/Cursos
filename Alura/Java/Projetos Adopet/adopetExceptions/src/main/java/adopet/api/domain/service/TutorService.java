package adopet.api.domain.service;

import adopet.api.domain.dto.CadastroTutorDTO;
import adopet.api.domain.dto.TutorDTO;
import adopet.api.domain.model.Tutor;
import adopet.api.domain.repository.ITutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TutorService {

    @Autowired
    private ITutorRepository repository;

    public List<TutorDTO> listarTodos(){
        return repository.findAll().stream().map(TutorDTO::new).toList();
    }
    public void cadastrar(CadastroTutorDTO dados){
        repository.save(new Tutor(dados));
    }
}

package br.com.LeoChiarelli.adopet.api.service;

import br.com.LeoChiarelli.adopet.api.exception.ValidacaoException;
import br.com.LeoChiarelli.adopet.api.model.Tutor;
import br.com.LeoChiarelli.adopet.api.repository.TutorRepository;
import org.springframework.stereotype.Service;

@Service
public class TutorService {

    private TutorRepository repository;

    public void cadastrar(Tutor tutor) {
        boolean telefoneJaCadastrado = repository.existsByTelefone(tutor.getTelefone());
        boolean emailJaCadastrado = repository.existsByEmail(tutor.getEmail());

        if (telefoneJaCadastrado || emailJaCadastrado) {
            throw new ValidacaoException("Dados já cadastrados para outro tutor!");
        } else {
            repository.save(tutor);
        }
    }

    public void atualizar(Tutor tutor){
        repository.save(tutor);
    }
}

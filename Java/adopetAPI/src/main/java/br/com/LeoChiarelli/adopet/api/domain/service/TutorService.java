package br.com.LeoChiarelli.adopet.api.domain.service;

import br.com.LeoChiarelli.adopet.api.domain.dto.AtualizarTutorDTO;
import br.com.LeoChiarelli.adopet.api.domain.dto.CadastrarTutorDTO;
import br.com.LeoChiarelli.adopet.api.domain.model.Tutor;
import br.com.LeoChiarelli.adopet.api.domain.repository.ITutorRepository;
import br.com.LeoChiarelli.adopet.api.general.exception.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TutorService {

    @Autowired
    private ITutorRepository repository;

    public void cadastrar(CadastrarTutorDTO dto) {

        boolean jaCadastado = repository.existsByTelefoneOrEmail(dto.telefone(), dto.email());

        if (jaCadastado) { throw new ValidacaoException("Dados já cadastrados para outro tutor!"); }
        repository.save(new Tutor(dto));
    }

    public void atualizar(AtualizarTutorDTO dto){
        var tutor = repository.getReferenceById(dto.id());
        tutor.atualizarDados(dto);
    }
}

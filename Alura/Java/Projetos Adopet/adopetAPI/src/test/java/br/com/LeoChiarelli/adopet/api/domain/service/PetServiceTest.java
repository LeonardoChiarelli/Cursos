package br.com.LeoChiarelli.adopet.api.domain.service;

import br.com.LeoChiarelli.adopet.api.domain.dto.CadastrarPetDTO;
import br.com.LeoChiarelli.adopet.api.domain.model.Abrigo;
import br.com.LeoChiarelli.adopet.api.domain.model.Pet;
import br.com.LeoChiarelli.adopet.api.domain.repository.IPetRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class PetServiceTest {

    @InjectMocks
    private PetService service;

    @Mock
    private CadastrarPetDTO cadastroPetDto;

    @Mock
    private IPetRepository repository;

    @Mock
    private Abrigo abrigo;


    @Test
    void listarTodosDisponiveis() {
        //Act
        service.listarTodosDisponiveis();

        //Assert
        then(repository).should().findAllByAdotadoFalse();
    }

    @Test
    void cadastrarPet() {
        //Act
        service.cadastrarPet(abrigo,cadastroPetDto);

        //Assert
        then(repository).should().save(new Pet(cadastroPetDto, abrigo));
    }
}
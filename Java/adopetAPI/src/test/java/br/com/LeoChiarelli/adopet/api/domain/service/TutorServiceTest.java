package br.com.LeoChiarelli.adopet.api.domain.service;

import br.com.LeoChiarelli.adopet.api.domain.dto.AtualizarTutorDTO;
import br.com.LeoChiarelli.adopet.api.domain.dto.CadastrarTutorDTO;
import br.com.LeoChiarelli.adopet.api.domain.model.Tutor;
import br.com.LeoChiarelli.adopet.api.domain.repository.ITutorRepository;
import br.com.LeoChiarelli.adopet.api.general.exception.ValidacaoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class TutorServiceTest {

    @InjectMocks
    private TutorService service;

    @Mock
    private ITutorRepository repository;

    @Mock
    private CadastrarTutorDTO dto;

    @Mock
    private Tutor tutor;

    @Mock
    private AtualizarTutorDTO atualizacaoTutorDto;



    @Test
    @DisplayName("Nao deveria cadastrar tutor telefone ou email ja cadastrado")
    void cadastrarCenario1() {
        //Arrange + Act
        given(repository.existsByTelefoneOrEmail(dto.telefone(), dto.email())).willReturn(true);

        //Assert
        assertThrows(ValidacaoException.class, () -> service.cadastrar(dto));
    }

    @Test
    @DisplayName("Deveria cadastrar tutor")
    void cadastrarCenario2() {
        //Arrange + Act
        given(repository.existsByTelefoneOrEmail(dto.telefone(), dto.email())).willReturn(false);

        //Assert
        assertDoesNotThrow(() -> service.cadastrar(dto));
        then(repository).should().save(new Tutor(dto));
    }

    @Test
    void atualizar() {
        //Arrange
        given(repository.getReferenceById(atualizacaoTutorDto.id())).willReturn(tutor);

        //Act
        service.atualizar(atualizacaoTutorDto);

        //Assert
        then(tutor).should().atualizarDados(atualizacaoTutorDto);
    }
}

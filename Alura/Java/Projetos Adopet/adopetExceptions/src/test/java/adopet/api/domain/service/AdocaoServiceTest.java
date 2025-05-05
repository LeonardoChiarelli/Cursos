package adopet.api.domain.service;

import adopet.api.domain.dto.SolicitacaoDeAdocaoDTO;
import adopet.api.domain.model.Adocao;
import adopet.api.domain.model.Pet;
import adopet.api.domain.model.StatusAdocao;
import adopet.api.domain.model.Tutor;
import adopet.api.domain.repository.IAdocaoRepository;
import adopet.api.domain.repository.IPetRepository;
import adopet.api.domain.repository.ITutorRepository;
import adopet.api.general.exception.ValidacaoException;
import adopet.api.general.strategy.IStrategy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AdocaoServiceTest {

    @InjectMocks
    private AdocaoService service;

    @Mock
    private IPetRepository petRepository;

    @Mock
    private ITutorRepository tutorRepository;

    @Mock
    private IAdocaoRepository adocaoRepository;

    private SolicitacaoDeAdocaoDTO dto;

    @Mock
    private Pet pet;

    @Mock
    private Tutor tutor;

    @Captor
    private ArgumentCaptor<Adocao> adocaoCaptor;

    private List<IStrategy> strategies;

    @Test
    @DisplayName("Deveria lançar exceção de pet já adotado quando solicitar adoção")
    void cenario1() {
        this.dto = new SolicitacaoDeAdocaoDTO(7L, 9L, "Motivo xpto");

        // Configurando mocks para o cenário
        given(petRepository.getReferenceById(this.dto.idPet())).willReturn(pet);
        given(pet.getAdotado()).willReturn(true);

        // Chamando o metodo e verificando a exceção
        Assertions.assertThrows(ValidacaoException.class, () -> {
            strategies.forEach(s -> s.validar(dto));
            service.solicitar(dto);
        });
    }

    @Test
    @DisplayName("Deveria lançar exceção de pet com adoção em andamento quando solicitar adoção")
    void cenario2() {
        this.dto = new SolicitacaoDeAdocaoDTO(7L, 9L, "Motivo xpto");

        // Configurando mocks para o cenário
        given(petRepository.getReferenceById(this.dto.idPet())).willReturn(pet);
        given(adocaoRepository.existsByPetIdAndStatus(this.dto.idPet(), StatusAdocao.AGUARDANDO_AVALIACAO)).willReturn(true);

        // Chamando o metodo e verificando a exceção
        ValidacaoException exception = Assertions.assertThrows(ValidacaoException.class, () -> service.solicitar(dto));

        // Validando a mensagem da exceção
        Assertions.assertEquals("Adoção já está em andamento para este pet.", exception.getMessage());
    }

    @Test
    @DisplayName("Deveria lançar exceção de tutor com máximo de adoções aprovadas quando solicitar adoção")
    void cenario3() {
        this.dto = new SolicitacaoDeAdocaoDTO(7L, 9L, "Motivo xpto");

        // Configurando mocks para o cenário
        given(petRepository.getReferenceById(this.dto.idPet())).willReturn(pet);
        given(tutorRepository.getReferenceById(this.dto.idTutor())).willReturn(tutor);
        given(adocaoRepository.countByTutorIdAndStatus(this.dto.idTutor(), StatusAdocao.APROVADO)).willReturn(5);

        // Chamando o metodo e verificando a exceção
        ValidacaoException exception = Assertions.assertThrows(ValidacaoException.class, () -> service.solicitar(dto));

        // Validando a mensagem da exceção
        Assertions.assertEquals("O tutor já atingiu o limite de adoções aprovadas.", exception.getMessage());
    }

    @Test
    @DisplayName("Deveria permitir solicitar adoção")
    void cenario4() {
        this.dto = new SolicitacaoDeAdocaoDTO(7L, 9L, "Motivo xpto");

        // Configurando mocks para o cenário
        given(petRepository.getReferenceById(dto.idPet())).willReturn(pet);
        given(tutorRepository.getReferenceById(dto.idTutor())).willReturn(tutor);

        // Simulando execução das estratégias
        strategies.forEach(s -> s.validar(dto));

        // Chamando o metodo principal
        service.solicitar(dto);

        // Verificando o salvamento da adoção
        then(adocaoRepository).should().save(adocaoCaptor.capture());
        Adocao adocaoSalvada = adocaoCaptor.getValue();

        // Validando os valores da adoção salva
        Assertions.assertEquals(pet, adocaoSalvada.getPet());
        Assertions.assertEquals(tutor, adocaoSalvada.getTutor());
        Assertions.assertEquals(dto.motivo(), adocaoSalvada.getMotivo());
    }
}
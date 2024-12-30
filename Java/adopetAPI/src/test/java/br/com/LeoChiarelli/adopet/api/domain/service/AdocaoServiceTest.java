package br.com.LeoChiarelli.adopet.api.domain.service;

import br.com.LeoChiarelli.adopet.api.domain.dto.SolicitarAdocaoDTO;
import br.com.LeoChiarelli.adopet.api.domain.email.SendEmail;
import br.com.LeoChiarelli.adopet.api.domain.model.Abrigo;
import br.com.LeoChiarelli.adopet.api.domain.model.Adocao;
import br.com.LeoChiarelli.adopet.api.domain.model.Pet;
import br.com.LeoChiarelli.adopet.api.domain.model.Tutor;
import br.com.LeoChiarelli.adopet.api.domain.repository.IAdocaoRepository;
import br.com.LeoChiarelli.adopet.api.domain.repository.IPetRepository;
import br.com.LeoChiarelli.adopet.api.domain.repository.ITutorRepository;
import br.com.LeoChiarelli.adopet.api.general.strategy.IStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class AdocaoServiceTest {

    @InjectMocks
    private AdocaoService service;

    @Mock
    private IAdocaoRepository adocaoRepository;

    @Mock
    private IPetRepository petRepository;

    @Mock
    private ITutorRepository tutorRepository;

    @Mock
    private SendEmail sendEmail;

    @Mock
    private List<IStrategy> validacoes;

    @Mock
    private Pet pet;

    @Mock
    private Tutor tutor;

    @Mock
    private Abrigo abrigo;

    @Captor
    private ArgumentCaptor<Adocao> captor;

    private SolicitarAdocaoDTO dto;

    @Test
    @DisplayName("Deve verificar se os dados estão sendo salvos no banco de dados")
    void solicitarCenario1() {
        // ARRANGE
        this.dto = new SolicitarAdocaoDTO(1L, 1L, "Motivo Qualquer");
        given(petRepository.getReferenceById(dto.idPet())).willReturn(pet);
        given(tutorRepository.getReferenceById(dto.idTutor())).willReturn(tutor);
        given(pet.getAbrigo()).willReturn(abrigo);

        // ACT
        service.solicitar(dto);

        // ASSERT
        then(adocaoRepository).should().save(captor.capture());
        var adocaoSalva = captor.getValue();
        assertEquals(pet, adocaoSalva.getPet());
        assertEquals(tutor, adocaoSalva.getTutor());
        assertEquals(dto.motivo(), adocaoSalva.getMotivo());

    }

    @Test
    @DisplayName("Deve verificar se as validações estão sendo feitas")
    void solicitarCenario2() {
        // ARRANGE
        this.dto = new SolicitarAdocaoDTO(1L, 1L, "Motivo Qualquer");
        given(petRepository.getReferenceById(dto.idPet())).willReturn(pet);
        given(tutorRepository.getReferenceById(dto.idTutor())).willReturn(tutor);
        given(pet.getAbrigo()).willReturn(abrigo);

        // ACT
        service.solicitar(dto);

        // ASSERT
        then(adocaoRepository).should().save(captor.capture());
        var adocaoSalva = captor.getValue();
        assertEquals(pet, adocaoSalva.getPet());
        assertEquals(tutor, adocaoSalva.getTutor());
        assertEquals(dto.motivo(), adocaoSalva.getMotivo());
    }

    @Test
    @DisplayName("Deve verificar se o email está sendo disparado")
    void solicitarCenario3() {
    }

    @Test
    void aprovar() {
    }

    @Test
    void reprovar() {
    }
}
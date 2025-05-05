package br.com.LeoChiarelli.adopet.api.domain.service;

import br.com.LeoChiarelli.adopet.api.domain.dto.AprovarAdocaoDTO;
import br.com.LeoChiarelli.adopet.api.domain.dto.ReprovarAdocaoDTO;
import br.com.LeoChiarelli.adopet.api.domain.dto.SolicitarAdocaoDTO;
import br.com.LeoChiarelli.adopet.api.domain.email.SendEmail;
import br.com.LeoChiarelli.adopet.api.domain.model.*;
import br.com.LeoChiarelli.adopet.api.domain.repository.IAdocaoRepository;
import br.com.LeoChiarelli.adopet.api.domain.repository.IPetRepository;
import br.com.LeoChiarelli.adopet.api.domain.repository.ITutorRepository;
import br.com.LeoChiarelli.adopet.api.general.strategy.IStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

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

    @Spy
    private List<IStrategy> validacoes = new ArrayList<>();

    @Mock
    private IStrategy strategy1;

    @Mock
    private IStrategy strategy2;

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
        validacoes.add(strategy1);
        validacoes.add(strategy2);


        // ACT
        service.solicitar(dto);

        // ASSERT
        then(strategy1).should().validar(dto);
        then(strategy2).should().validar(dto);

    }

    @Test
    @DisplayName("Deve verificar se o email está sendo disparado")
    void solicitarCenario3() {
        this.dto = new SolicitarAdocaoDTO(1L, 1L, "Motivo Qualquer");
        given(petRepository.getReferenceById(dto.idPet())).willReturn(pet);
        given(tutorRepository.getReferenceById(dto.idTutor())).willReturn(tutor);
        given(pet.getAbrigo()).willReturn(abrigo);
        var adocao = new Adocao(pet, tutor, dto.motivo());

        // ACT
        service.solicitar(dto);

        // ASSERT
        then(sendEmail).should().enviarEmail(pet.getAbrigo().getEmail(), "Solicitação de adoção", "Olá " + pet.getAbrigo().getNome() + "!\n\nUma solicitação de adoção foi registrada hoje para o pet: "  + adocao.getPet().getNome() +". \nFavor avaliar para aprovação ou reprovação.");
    }

    @Test
    @DisplayName("Testa se o Status da adoção foi alterado")
    void aprovarCenario1() {
        this.dto = new SolicitarAdocaoDTO(1L, 1L, "Motivo Qualquer");

        var abrigo = new Abrigo(1L, "Abrigo Feliz", "abrigo@example.com");
        var pet = new Pet(1L, "Buddy", abrigo);
        var tutor = new Tutor(1L, "Carlos", "carlos@example.com");
        var adocao = new Adocao(pet, tutor, dto.motivo());

        var aprovarAdocaoDTO = new AprovarAdocaoDTO(adocao.getId());
        given(adocaoRepository.getReferenceById(aprovarAdocaoDTO.idAdocao())).willReturn(adocao);

        // ACT
        service.aprovar(aprovarAdocaoDTO);

        // ASSERT
        assertEquals(StatusAdocao.APROVADO, adocao.getStatus());
    }

    @Test
    @DisplayName("Testa se o email foi lançado")
    void aprovarCenario2() {
        this.dto = new SolicitarAdocaoDTO(1L, 1L, "Motivo Qualquer");

        var abrigo = new Abrigo(1L, "Abrigo Feliz", "abrigo@example.com");
        var pet = new Pet(1L, "Buddy", abrigo);
        var tutor = new Tutor(1L, "Carlos", "carlos@example.com");
        var adocao = new Adocao(pet, tutor, dto.motivo());

        var aprovarAdocaoDTO = new AprovarAdocaoDTO(adocao.getId());
        given(adocaoRepository.getReferenceById(aprovarAdocaoDTO.idAdocao())).willReturn(adocao);

        // ACT
        service.aprovar(aprovarAdocaoDTO);

        // ASSERT
        verify(sendEmail, times(1)).enviarEmail(eq(tutor.getEmail()), anyString(), anyString());
    }

    @Test
    @DisplayName("Verifica se o status da adoção foi alterado")
    void reprovarCenario1() {
        this.dto = new SolicitarAdocaoDTO(1L, 1L, "Motivo Qualquer");

        var abrigo = new Abrigo(1L, "Abrigo Feliz", "abrigo@example.com");
        var pet = new Pet(1L, "Buddy", abrigo);
        var tutor = new Tutor(1L, "Carlos", "carlos@example.com");
        var adocao = new Adocao(pet, tutor, dto.motivo());

        var reprovarAdocaoDTO = new ReprovarAdocaoDTO(adocao.getId(), "Justificativa");;
        given(adocaoRepository.getReferenceById(reprovarAdocaoDTO.idAdocao())).willReturn(adocao);

        // ACT
        service.reprovar(reprovarAdocaoDTO);

        // ASSERT
        assertEquals(StatusAdocao.REPROVADO, adocao.getStatus());
    }

    @Test
    @DisplayName("Verifica se a Justificativa")
    void reprovarCenario2() {
        this.dto = new SolicitarAdocaoDTO(1L, 1L, "Motivo Qualquer");

        var abrigo = new Abrigo(1L, "Abrigo Feliz", "abrigo@example.com");
        var pet = new Pet(1L, "Buddy", abrigo);
        var tutor = new Tutor(1L, "Carlos", "carlos@example.com");
        var adocao = new Adocao(pet, tutor, dto.motivo());

        var reprovarAdocaoDTO = new ReprovarAdocaoDTO(adocao.getId(), "Justificativa");;
        given(adocaoRepository.getReferenceById(reprovarAdocaoDTO.idAdocao())).willReturn(adocao);

        // ACT
        service.reprovar(reprovarAdocaoDTO);

        // ASSERT
        assertEquals("Justificativa", adocao.getJustificativaStatus()); // Verifica a justificativa
    }

    @Test
    @DisplayName("Verifica se o email foi enviado")
    void reprovarCenario3() {
        this.dto = new SolicitarAdocaoDTO(1L, 1L, "Motivo Qualquer");

        var abrigo = new Abrigo(1L, "Abrigo Feliz", "abrigo@example.com");
        var pet = new Pet(1L, "Buddy", abrigo);
        var tutor = new Tutor(1L, "Carlos", "carlos@example.com");
        var adocao = new Adocao(pet, tutor, dto.motivo());

        var reprovarAdocaoDTO = new ReprovarAdocaoDTO(adocao.getId(), "Justificativa");;
        given(adocaoRepository.getReferenceById(reprovarAdocaoDTO.idAdocao())).willReturn(adocao);

        // ACT
        service.reprovar(reprovarAdocaoDTO);

        // ASSERT
        verify(sendEmail, times(1)).enviarEmail(eq(tutor.getEmail()), anyString(), anyString());
    }
}
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
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

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

    @Test
    @DisplayName("Deveria lançar excecao de pet ja adotado quando solicitar adocao")
    void cenario1(){

        this.dto = new SolicitacaoDeAdocaoDTO(7L,9L,"Motivo xpto");

        given(petRepository.getReferenceById(this.dto.idPet())).willReturn(pet);
        given(pet.getAdotado()).willReturn(true);


        Assertions.assertThrows(ValidacaoException.class, () -> service.solicitar(dto));
    }


    @Test
    @DisplayName("Deveria lançar excecao de pet com adocao em andamento quando solicitar adocao")
    void cenario2(){

        this.dto = new SolicitacaoDeAdocaoDTO(7L,9L,"Motivo xpto");

        given(petRepository.getReferenceById(this.dto.idPet())).willReturn(pet);
        given(adocaoRepository.existsByPetIdAndStatus(this.dto.idPet(), StatusAdocao.AGUARDANDO_AVALIACAO)).willReturn(true);

        Assertions.assertThrows(ValidacaoException.class, () -> service.solicitar(dto));
    }

    @Test
    @DisplayName("Deveria lancar excecao de tutor com maximo de adocoes aprovadas quando solicitar adocao")
    void cenario3(){

        this.dto = new SolicitacaoDeAdocaoDTO(7L,9L,"Motivo xpto");

        given(petRepository.getReferenceById(dto.idPet())).willReturn(pet);
        given(tutorRepository.getReferenceById(dto.idTutor())).willReturn(tutor);
        given(adocaoRepository.countByTutorIdAndStatus(dto.idTutor(), StatusAdocao.APROVADO)).willReturn(2);

        Assertions.assertThrows(ValidacaoException.class, () -> service.solicitar(dto));
    }


    @Test
    @DisplayName("Deveria permitir solicitar adocao")
    void cenario4(){

        this.dto = new SolicitacaoDeAdocaoDTO(7L,9L,"Motivo xpto");
        given(petRepository.getReferenceById(dto.idPet())).willReturn(pet);
        given(tutorRepository.getReferenceById(dto.idTutor())).willReturn(tutor);

        service.solicitar(dto);

        then(adocaoRepository).should().save(adocaoCaptor.capture());
        Adocao adocaoSalvada = adocaoCaptor.getValue();

        Assertions.assertEquals(pet, adocaoSalvada.getPet());
        Assertions.assertEquals(tutor, adocaoSalvada.getTutor());
        Assertions.assertEquals(dto.motivo(), adocaoSalvada.getMotivo());
    }

}
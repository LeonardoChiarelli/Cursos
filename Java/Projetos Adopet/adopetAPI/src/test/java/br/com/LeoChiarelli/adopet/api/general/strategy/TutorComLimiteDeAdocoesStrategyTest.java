package br.com.LeoChiarelli.adopet.api.general.strategy;

import br.com.LeoChiarelli.adopet.api.domain.dto.SolicitarAdocaoDTO;
import br.com.LeoChiarelli.adopet.api.domain.model.Adocao;
import br.com.LeoChiarelli.adopet.api.domain.model.StatusAdocao;
import br.com.LeoChiarelli.adopet.api.domain.model.Tutor;
import br.com.LeoChiarelli.adopet.api.domain.repository.IAdocaoRepository;
import br.com.LeoChiarelli.adopet.api.domain.repository.ITutorRepository;
import br.com.LeoChiarelli.adopet.api.general.exception.ValidacaoException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TutorComLimiteDeAdocoesStrategyTest {

    @InjectMocks
    private TutorComLimiteDeAdocoesStrategy strategy;

    @Mock
    private SolicitarAdocaoDTO dto;

    @Mock
    private IAdocaoRepository adocaoRepository;

    @Mock
    private ITutorRepository tutorRepository;

    @Mock
    private Tutor tutor;

    @Test
    @DisplayName("Não há devolução esperada")
    void validarCenario1() {
        List<Adocao> adocoes = new ArrayList<>();
        for(int i = 0; i < 4; i++){
            Adocao adocao = new Adocao(tutor, StatusAdocao.APROVADO);
            adocoes.add(adocao);
        }

        when(adocaoRepository.findAll()).thenReturn(adocoes);
        when(tutorRepository.getReferenceById(dto.idTutor())).thenReturn(tutor);

        strategy.validar(dto);

        verify(adocaoRepository, times(1)).findAll();
        verify(tutorRepository, times(1)).getReferenceById(dto.idTutor());

    }

    @Test
    @DisplayName("Deveria devolver uma exception")
    void validarCenario2() {

        List<Adocao> adocoes = new ArrayList<>();
        for(int i = 0; i < 5; i++){
            Adocao adocao = new Adocao(tutor, StatusAdocao.APROVADO);
            adocoes.add(adocao);
        }

        when(adocaoRepository.findAll()).thenReturn(adocoes);
        when(tutorRepository.getReferenceById(dto.idTutor())).thenReturn(tutor);

        Assertions.assertThrows(ValidacaoException.class, () -> strategy.validar(dto));

        verify(adocaoRepository, times(1)).findAll();
        verify(tutorRepository, times(1)).getReferenceById(dto.idTutor());
    }
}
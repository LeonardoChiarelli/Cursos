package br.com.LeoChiarelli.adopet.api.general.strategy;

import br.com.LeoChiarelli.adopet.api.domain.dto.SolicitarAdocaoDTO;
import br.com.LeoChiarelli.adopet.api.domain.model.StatusAdocao;
import br.com.LeoChiarelli.adopet.api.domain.repository.IAdocaoRepository;
import br.com.LeoChiarelli.adopet.api.general.exception.ValidacaoException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class TutorComAdocaoEmAvaliacaoStrategyTest {

    @InjectMocks
    private TutorComAdocaoEmAvaliacaoStrategy strategy = new TutorComAdocaoEmAvaliacaoStrategy();

    @Mock
    private IAdocaoRepository repository;

    @Mock
    private SolicitarAdocaoDTO dto;

    @Test
    @DisplayName("Não há devolução esperada")
    void validarCenario1() {

        BDDMockito.given(repository.existsByTutorIdAndStatus(dto.idTutor(), StatusAdocao.AGUARDANDO_AVALIACAO)).willReturn(false);

        Assertions.assertDoesNotThrow(() -> strategy.validar(dto));
    }

    @Test
    @DisplayName("Deveria retornar uma exception")
    void validarCenario2() {

        BDDMockito.given(repository.existsByTutorIdAndStatus(dto.idTutor(), StatusAdocao.AGUARDANDO_AVALIACAO)).willReturn(true);

        Assertions.assertThrows(ValidacaoException.class, () -> strategy.validar(dto));
    }
}
package br.com.LeoChiarelli.adopet.api.general.strategy;

import br.com.LeoChiarelli.adopet.api.domain.dto.SolicitarAdocaoDTO;
import br.com.LeoChiarelli.adopet.api.domain.model.Pet;
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
class PetComAdocaoEmAndamentoStrategyTest {

    @InjectMocks
    private PetComAdocaoEmAndamentoStrategy strategy = new PetComAdocaoEmAndamentoStrategy();

    @Mock
    private IAdocaoRepository repository;

    @Mock
    private SolicitarAdocaoDTO dto;

    @Mock
    private Pet pet;


    @Test
    @DisplayName("Não há devolução esperada")
    void validarCenario1() {

        BDDMockito.given(repository.existsByPetIdAndStatus(dto.idPet(), StatusAdocao.AGUARDANDO_AVALIACAO)).willReturn(false);

        Assertions.assertDoesNotThrow(() -> strategy.validar(dto));
    }

    @Test
    @DisplayName("Deveria devolver uma exception")
    void validarCenario2() {

        BDDMockito.given(repository.existsByPetIdAndStatus(dto.idPet(), StatusAdocao.AGUARDANDO_AVALIACAO)).willReturn(true);

        Assertions.assertThrows(ValidacaoException.class, () -> strategy.validar(dto));
    }
}
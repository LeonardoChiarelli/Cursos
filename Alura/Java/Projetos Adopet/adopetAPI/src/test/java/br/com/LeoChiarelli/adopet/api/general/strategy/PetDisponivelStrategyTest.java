package br.com.LeoChiarelli.adopet.api.general.strategy;

import br.com.LeoChiarelli.adopet.api.domain.dto.SolicitarAdocaoDTO;
import br.com.LeoChiarelli.adopet.api.domain.model.Pet;
import br.com.LeoChiarelli.adopet.api.domain.repository.IPetRepository;
import br.com.LeoChiarelli.adopet.api.general.exception.ValidacaoException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class) // Para fazer com que o mockito intercepte essa classe
class PetDisponivelStrategyTest {

    @InjectMocks
    private PetDisponivelStrategy strategy = new PetDisponivelStrategy();

    @Mock
    private IPetRepository repository;

    @Mock
    private Pet pet;

    @Mock
    private SolicitarAdocaoDTO dto;

    @Test
    @DisplayName("Não há devolução esperada")
    void validarCenario1() {

        BDDMockito.given(repository.getReferenceById(dto.idPet())).willReturn(pet); // "Dado um determinado cenário, você vai fazer isso"
        BDDMockito.given(pet.getAdotado()).willReturn(false);

        Assertions.assertDoesNotThrow(() -> strategy.validar(dto)); // formato de lambda

    }

    @Test
    @DisplayName("Devaria devolver uma exception 'Pet já adotado'")
    void validarCenario2() {

        BDDMockito.given(repository.getReferenceById(dto.idPet())).willReturn(pet);
        BDDMockito.given(pet.getAdotado()).willReturn(true);

        Assertions.assertThrows(ValidacaoException.class, ()->  strategy.validar(dto));

    }
}
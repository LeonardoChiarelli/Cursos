package br.com.LeoChiarelli.adopet.api.domain.service;

import br.com.LeoChiarelli.adopet.api.domain.model.Abrigo;
import br.com.LeoChiarelli.adopet.api.domain.repository.IAbrigoRepository;
import br.com.LeoChiarelli.adopet.api.domain.repository.IPetRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class AbrigoServiceTest {

    @InjectMocks
    private AbrigoService service;

    @Mock
    private IAbrigoRepository repository;

    @Mock
    private Abrigo abrigo;

    @Mock
    private IPetRepository petRepository;

    @Test
    @DisplayName("Deveria chamar lista de todos os abrigos")
    void listar() {
        //Act
        service.listar();

        //Assert
        then(repository).should().findAll();
    }

    @Test
    @DisplayName("Deveria chamar lista de pets atraves do nome")
    void listarPets() {
        //Arrange
        String nome = "Miau";
        given(repository.findByNome(nome)).willReturn(abrigo);

        //Act
        service.listarPets(nome);

        //Assert
        then(petRepository).should().findByAbrigo(abrigo);

    }

}
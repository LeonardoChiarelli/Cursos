package br.com.LeoChiarelli.adopet.api.domain.controller;

import br.com.LeoChiarelli.adopet.api.domain.model.Abrigo;
import br.com.LeoChiarelli.adopet.api.domain.service.AbrigoService;
import br.com.LeoChiarelli.adopet.api.domain.service.PetService;
import br.com.LeoChiarelli.adopet.api.general.exception.ValidacaoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
class AbrigoControllerTest {

    @MockitoBean
    private AbrigoService abrigoService;

    @MockitoBean
    private PetService petservice;

    @Mock
    private Abrigo abrigo;

    @Autowired
    private MockMvc mvc;


    @Test
    @DisplayName("Deveria devolver código 200 para requisição de listarAbrigo")
    void listar() throws Exception {

        var response = mvc.perform(
                get("/abrigos")
        ).andReturn().getResponse();

        assertEquals(200, response.getStatus());
    }

    @Test
    @DisplayName("Deveria devolver código 200")
    void cadastrarCenario1() throws Exception {
        String json = """
                {
                    "nome": "Abrigo feliz",
                    "telefone": "(94)0000-9090",
                    "email": "email@example.com.br"
                }
                """;

        var response = mvc.perform(
                post("/abrigos")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse();

        assertEquals(200, response.getStatus());
    }

    @Test
    @DisplayName("Deveria devolver código 400")
    void cadastrarCenario2() throws Exception {
        String json = """
                {
                
                }
                """;

        var response = mvc.perform(
                post("/abrigos")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse();

        assertEquals(400, response.getStatus());
    }

    @Test
    @DisplayName("Deveria devolver codigo 200 para requisicao de listar pets do abrigo por nome")
    void listarPetsCenario1() throws Exception {
        //Arrange
        String nome = "Abrigo feliz";

        //Act
        MockHttpServletResponse response = mvc.perform(
                get("/abrigos/{nome}/pets",nome)
        ).andReturn().getResponse();

        //Assert
        assertEquals(200,response.getStatus());
    }

    @Test
    @DisplayName("Deveria devolver codigo 200 para requisicao de listar pets do abrigo por id")
    void listarPetsCenario2() throws Exception {
        //Arrange
        String id = "1";

        //Act
        MockHttpServletResponse response = mvc.perform(
                get("/abrigos/{nome}/pets",id)
        ).andReturn().getResponse();

        //Assert
        assertEquals(200,response.getStatus());
    }

    @Test
    @DisplayName("Deveria devolver codigo 404 para requisicao de listar pets do abrigo por id inválido")
    void listarPetsCenario3() throws Exception {
        //Arrange
        String id = "1";
        given(abrigoService.listarPets(id)).willThrow(ValidacaoException.class);

        //Act
        MockHttpServletResponse response = mvc.perform(
                get("/abrigos/{id}/pets",id)
        ).andReturn().getResponse();

        //Assert
        assertEquals(404,response.getStatus());
    }

    @Test
    @DisplayName("Deveria devolver codigo 404 para requisicao de listar pets do abrigo por nome inválido")
    void listarPetsCenario4() throws Exception {
        //Arrange
        String nome = "Miau";
        given(abrigoService.listarPets(nome)).willThrow(ValidacaoException.class);

        //Act
        var response = mvc.perform(
                get("/abrigos/{nome}/pets",nome)
        ).andReturn().getResponse();

        //Assert
        assertEquals(404,response.getStatus());
    }

    @Test
    @DisplayName("Deveria devolver codigo 200 para requisicao de cadastrar pet pelo id")
    void cadastrarPetCenario1() throws Exception {
        //Arange
        String json = """
                {
                    "tipoPet": "GATO",
                    "nome": "Miau",
                    "raca": "padrao",
                    "idade": "5",
                    "cor" : "Parda",
                    "peso": "6.4"
                }
                """;

        String abrigoId = "1";

        //Act
        var response = mvc.perform(
                post("/abrigos/{abrigoId}/pets",abrigoId)
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse();

        //Assert
        assertEquals(200,response.getStatus());
    }

    @Test
    @DisplayName("Deveria devolver codigo 200 para requisicao de cadastrar pet pelo nome")
    void cadastrarPetCenario2() throws Exception {
        //Arange
        String json = """
                {
                    "tipoPet": "GATO",
                    "nome": "Miau",
                    "raca": "padrao",
                    "idade": "5",
                    "cor" : "Parda",
                    "peso": "6.4"
                }
                """;

        String abrigoNome = "Abrigo feliz";

        //Act
        var response = mvc.perform(
                post("/abrigos/{abrigoId}/pets",abrigoNome)
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse();

        //Assert
        assertEquals(200,response.getStatus());
    }

    @Test
    @DisplayName("Deveria devolver codigo 404 para requisicao de cadastrar pet não encontrado pelo id")
    void cadastrarPetCenario3() throws Exception {
        //Arange
        String json = """
                {
                    "tipoPet": "GATO",
                    "nome": "Miau",
                    "raca": "padrao",
                    "idade": "5",
                    "cor" : "Parda",
                    "peso": "6.4"
                }
                """;

        String abrigoId = "1";
        given(abrigoService.carregarAbrigo(abrigoId)).willThrow(ValidacaoException.class);

        //Act
        var response = mvc.perform(
                post("/abrigos/{abrigoId}/pets",abrigoId)
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse();

        //Assert
        assertEquals(404,response.getStatus());
    }

    @Test
    @DisplayName("Deveria devolver codigo 404 para requisicao de cadastrar pet não encontrado pelo nome")
    void cadastrarPetCenario4() throws Exception {
        //Arange
        String json = """
                {
                    "tipoPet": "GATO",
                    "nome": "Miau",
                    "raca": "padrao",
                    "idade": "5",
                    "cor" : "Parda",
                    "peso": "6.4"
                }
                """;

        String abrigoNome = "Abrigo legal";
        given(abrigoService.carregarAbrigo(abrigoNome)).willThrow(ValidacaoException.class);

        //Act
        var response = mvc.perform(
                post("/abrigos/{abrigoId}/pets",abrigoNome)
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse();

        //Assert
        assertEquals(404,response.getStatus());
    }
}
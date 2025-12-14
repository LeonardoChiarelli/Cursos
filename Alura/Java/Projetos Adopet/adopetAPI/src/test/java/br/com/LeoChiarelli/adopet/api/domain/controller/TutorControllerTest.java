package br.com.LeoChiarelli.adopet.api.domain.controller;

import br.com.LeoChiarelli.adopet.api.domain.service.TutorService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

@SpringBootTest
@AutoConfigureMockMvc
class TutorControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockitoBean
    private TutorService service;

    @Test
    @DisplayName("Deveria devolver codigo 200 para requisicao de cadastrar tutor")
    void cadastrarCenario1() throws Exception {
        //Arrange
        String json = """
                {
                    "nome": "Leonardo",
                    "telefone": "1111111-9090",
                    "email": "email@gmail.com.br"
                }
                """;
        //Act
        var response = mvc.perform(
                post("/tutores")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse();

        //Assert
        assertEquals(200,response.getStatus());
    }

    @Test
    @DisplayName("Deveria devolver codigo 400 para requisicao de cadastrar tutor dados inválidos")
    void cadastrarCenario2() throws Exception {
        //Arrange
        String json = """
                {
                    "nome": "Leonardo",
                    "telefone": "(21)0000-9090",
                    "email": "email@example.com.br"
                }
                """;
        //Act
        var response = mvc.perform(
                post("/tutores")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse();

        //Assert
        assertEquals(400,response.getStatus());
    }

    @Test
    @DisplayName("Deveria devolver codigo 200 para requisicao de atualizar tutor")
    void atualizarCenario1() throws Exception {
        //Arrange
        String json = """
                {
                    "id" : "1",
                    "nome": "Leonardo",
                    "telefone": "1101000-9090",
                    "email": "email@gmail.com"
                }
                """;

        //Act
        var response = mvc.perform(
                put("/tutores")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse();

        //Assert
        assertEquals(200,response.getStatus());
    }

    @Test
    @DisplayName("Deveria devolver codigo 400 para requisicao de atualizar tutor dados inválidos")
    void atualizarCenario2() throws Exception {
        //Arrange
        String json = """
                {
                    "id" : "1",
                    "nome": "Leonardo",
                    "telefone": "(21)0000-9090",
                    "email": "email@example.com"
                }
                """;

        //Act
        var response = mvc.perform(
                put("/tutores")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse();

        //Assert
        assertEquals(400,response.getStatus());
    }
}
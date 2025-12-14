package br.com.LeoChiarelli.adopet.api.domain.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
class PetControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    @DisplayName("Deveria devolver codigo 200 para requisicao de listar todos pets disponiveis")
    void listarTodosDisponiveis() throws Exception {
        //Act
        var response = mvc.perform(
                get("/pets")
                        .contentType(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse();

        //Assert
        assertEquals(200,response.getStatus());
    }
}
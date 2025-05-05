package br.com.LeoChiarelli.adopet.api.domain.controller;

import br.com.LeoChiarelli.adopet.api.domain.service.AdocaoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

@SpringBootTest
@AutoConfigureMockMvc
class AdocaoControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockitoBean
    AdocaoService service;

    @Test
    @DisplayName("Deveria devolver código 200")
    void solicitarCenario1() throws Exception {
        // ARRANGE
        String json = """
                {
                "idPet": "1",
                "idTutor": "1",
                "motivo": "Motivo Qualquer"
                }
                """;

        // ACT
        var response = mvc.perform(
                post("/adocoes")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse();

        // ASSERT
        assertEquals(200, response.getStatus());
        assertEquals("Adoção solicitada com sucesso!", response.getContentAsString());
    }

    @Test
    @DisplayName("Deveria devolver código 400 - Solicitação com erros")
    void solicitarCenario2() throws Exception {
        // ARRANGE
        String json = "{}";

        // ACT
        var response = mvc.perform(
                post("/adocoes")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse();

        // ASSERT
        assertEquals(400, response.getStatus());
    }

    @Test
    @DisplayName("Deveria devolver código 200")
    void aprovarCenario1() throws Exception {
        //ARRANGE
        String json = """
                {
                    "idAdocao": "1"
                }
                """;

        // ACT
        var response = mvc.perform(
                put("/adocoes/aprovar")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse();

        // ASSERT
        assertEquals(200, response.getStatus());
    }

    @Test
    @DisplayName("Deveria devolver código 400 - Solicitações erradas")
    void aprovarCenario2() throws Exception {
        //ARRANGE
        String json = """
                {
                    
                }
                """;

        // ACT
        var response = mvc.perform(
                put("/adocoes/aprovar")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse();

        // ASSERT
        assertEquals(400, response.getStatus());
    }

    @Test
    @DisplayName("Deveria devolver código 200")
    void reprovarCenario1() throws Exception {
        //ARRANGE
        String json = """
                {
                    "idAdocao": "1",
                    "justificativa": "Justificativa"
                }
                """;

        // ACT
        var response = mvc.perform(
                put("/adocoes/reprovar")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse();

        // ASSERT
        assertEquals(200, response.getStatus());
    }

    @Test
    @DisplayName("Deveria devolver código 400 - Solicitação errada")
    void reprovarCenario2() throws Exception {
        //ARRANGE
        String json = """
                {
                
                }
                """;

        // ACT
        var response = mvc.perform(
                put("/adocoes/reprovar")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse();

        // ASSERT
        assertEquals(400, response.getStatus());
    }
}
package br.com.LeoChiarelli.api.domain.controller;

import br.com.LeoChiarelli.api.domain.dto.AppointmentDTO;
import br.com.LeoChiarelli.api.domain.dto.AppointmentDetailingDTO;
import br.com.LeoChiarelli.api.domain.models.Specialty;
import br.com.LeoChiarelli.api.domain.service.AppointmentService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class AppointmentControllerTest {

    @Autowired
    protected MockMvc mvc;

    @Autowired
    protected JacksonTester<AppointmentDTO> appointmentDTOJson;

    @Autowired
    protected JacksonTester<AppointmentDetailingDTO> appointmentDetailingDTOJson;

    @MockitoBean
    protected AppointmentService appointmentService;

    @Test
    @DisplayName("Deveria devolver código http 400 quando informações estão inválidas")
    @WithMockUser // Para passar ao Spring um usuário 'Mockado', para considerar para o Spring Security que estamos logados
    void scheduleScenario1() throws Exception {
        var response = mvc.perform(post("/consultas"))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    @DisplayName("Deveria devolver código http 200 quando informações estão corretas")
    @WithMockUser
    void scheduleScenario2() throws Exception{
        var data = LocalDateTime.now().plusHours(1);
        var especialidade = Specialty.CARDIOLOGIA;

        var dadosDetalhamento = new AppointmentDetailingDTO(null, 1L, 1L, data);

        when(appointmentService.schedule(any())).thenReturn(dadosDetalhamento);

        var response = mvc.perform(
                        post("/consultas")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(appointmentDTOJson.write(
                                        new AppointmentDTO(1L, 1L, data, especialidade)
                                ).getJson())
                )
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());

        var jsonEsperado = appointmentDetailingDTOJson.write(dadosDetalhamento).getJson();

        assertThat(response.getContentAsString()).isEqualTo(jsonEsperado);
    }
}
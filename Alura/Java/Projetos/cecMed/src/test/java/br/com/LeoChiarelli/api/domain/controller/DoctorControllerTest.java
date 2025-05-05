package br.com.LeoChiarelli.api.domain.controller;

import br.com.LeoChiarelli.api.domain.dto.AddressDTO;
import br.com.LeoChiarelli.api.domain.dto.AppointmentDTO;
import br.com.LeoChiarelli.api.domain.dto.DoctorDTO;
import br.com.LeoChiarelli.api.domain.dto.DoctorsDetailingDTO;
import br.com.LeoChiarelli.api.domain.models.Address;
import br.com.LeoChiarelli.api.domain.models.Doctor;
import br.com.LeoChiarelli.api.domain.models.Specialty;
import br.com.LeoChiarelli.api.domain.repository.IDoctorRepository;
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

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class DoctorControllerTest {

    @Autowired
    protected MockMvc mvc;

    @Autowired
    protected JacksonTester<DoctorDTO> doctorDTOJson;

    @Autowired
    protected JacksonTester<DoctorsDetailingDTO> doctorsDetailingDTOJson;

    @MockitoBean
    protected IDoctorRepository repository;

    @Test
    @DisplayName("Deveria devolver código http 400 quando informações estão inválidas")
    @WithMockUser
    void registerScenario1() throws Exception {
        var response = mvc
                .perform(post("/medicos"))
                .andReturn().getResponse();

        assertThat(response.getStatus())
                .isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    @DisplayName("Deveria devolver código http 400 quando informações estão válidas")
    @WithMockUser
    void registerScenario2() throws Exception {
        var dadosCadastro = new DoctorDTO(
                null,
                "Medico",
                "medico@cec.med",
                "61999999999",
                "123456",
                Specialty.CARDIOLOGIA,
                dadosEndereco()
        );

        when(repository.save(any())).thenReturn(new Doctor(dadosCadastro));

        var response = mvc
                .perform(post("/medicos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(doctorDTOJson.write(dadosCadastro).getJson()))
                        .andReturn().getResponse();

        var dadosDetalhamento = new DoctorsDetailingDTO(
                null,
                dadosCadastro.nome(),
                dadosCadastro.email(),
                dadosCadastro.crm(),
                dadosCadastro.telefone(),
                dadosCadastro.especialidade(),
                new Address(dadosCadastro.endereco())
        );
        var jsonEsperado = doctorsDetailingDTOJson.write(dadosDetalhamento).getJson();

        assertThat(response.getStatus())
                .isEqualTo(HttpStatus.CREATED.value());
        assertThat(response.getContentAsString()).isEqualTo(jsonEsperado);
    }

    private AddressDTO dadosEndereco(){
        return new AddressDTO(
                "rua xpto",
                "bairro",
                "00000000",
                "São Paulo",
                "SP",
                null, null
        );
    }
}
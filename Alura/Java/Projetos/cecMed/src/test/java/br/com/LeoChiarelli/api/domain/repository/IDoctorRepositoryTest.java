package br.com.LeoChiarelli.api.domain.repository;

import br.com.LeoChiarelli.api.domain.dto.AddressDTO;
import br.com.LeoChiarelli.api.domain.dto.DoctorDTO;
import br.com.LeoChiarelli.api.domain.dto.PatientDTO;
import br.com.LeoChiarelli.api.domain.models.Appointment;
import br.com.LeoChiarelli.api.domain.models.Doctor;
import br.com.LeoChiarelli.api.domain.models.Patient;
import br.com.LeoChiarelli.api.domain.models.Specialty;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest // Utilizada para testar uma interface Repository
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class IDoctorRepositoryTest {

    @Autowired
    protected IDoctorRepository repository;

    @Autowired
    protected TestEntityManager em;

    @Test
    @DisplayName("Deveria devolver 'null' quando único medico cadastrado não está disponível na data")
    void chooseRandomDoctorScenario1() {
        // GIVEN / ARRANGE
        var proximaSegundaAs10 = LocalDate.now()
                .with(TemporalAdjusters.next(DayOfWeek.MONDAY))
                .atTime(10, 0);
        var medico = cadastrarMedico("Medico", "medico@cec.med", "123456", Specialty.CARDIOLOGIA);
        var paciente = cadastrarPaciente("Paciente", "paciente@gmail.com", "12345678912");
        cadastrarConsulta(medico, paciente, proximaSegundaAs10);

        // WHEN / ACT
        var medicoLivre = repository.chooseRandomDoctor(Specialty.CARDIOLOGIA, proximaSegundaAs10);

        // THEN / ASSERT
        assertThat(medicoLivre).isNull();
    }

    @Test
    @DisplayName("Deveria devolver 'Doctor' quando ele estiver disponível na data")
    void chooseRandomDoctorScenario2() {
        var proximaSegundaAs10 = LocalDate.now()
                .with(TemporalAdjusters.next(DayOfWeek.MONDAY))
                .atTime(10, 0);

        var medico = cadastrarMedico("Medico", "medico@cec.med", "123456", Specialty.CARDIOLOGIA);

        var medicoLivre = repository.chooseRandomDoctor(Specialty.CARDIOLOGIA, proximaSegundaAs10);

        assertThat(medicoLivre).isEqualTo(medico);
    }

    @Test
    @DisplayName("Deveria devolver 'Doctor' quando ele estiver disponível na data")
    void chooseRandomDoctorScenario3() {
        var proximaSegundaAs10 = LocalDate.now()
                .with(TemporalAdjusters.next(DayOfWeek.MONDAY))
                .atTime(10, 0);

        var medico = cadastrarMedico("Medico", "medico@cec.med", "123456", Specialty.CARDIOLOGIA);

        var medicoLivre = repository.chooseRandomDoctor(Specialty.CARDIOLOGIA, proximaSegundaAs10);

        assertThat(medicoLivre).isEqualTo(medico);
    }

    // Metodos

    private void cadastrarConsulta(Doctor medico, Patient paciente, LocalDateTime data){
        em.persist(new Appointment(null, medico, paciente, data, null));
    }

    private Doctor cadastrarMedico(String nome, String email, String crm, Specialty especialidade){
        var medico = new Doctor(dadosMedico(nome, email, crm, especialidade));
        em.persist(medico);
        return medico;
    }

    private Patient cadastrarPaciente(String nome, String email, String cpf){
        var paciente = new Patient(dadosPaciente(nome, email, cpf));
        em.persist(paciente);
        return paciente;
    }

    private DoctorDTO dadosMedico(String nome, String email, String crm, Specialty especialidade){
        return new DoctorDTO(
                null,
                nome,
                email,
                "61999999999",
                crm,
                especialidade,
                dadosEndereco()
        );
    }

    private PatientDTO dadosPaciente(String nome, String email, String cpf){
        return new PatientDTO(
                nome,
                email,
                "61999999999",
                cpf,
                dadosEndereco()
        );
    }

    private AddressDTO dadosEndereco(){
        return new AddressDTO(
                "rua xpto",
                "bairro",
                "00000000",
                "São Paulo",
                "SP",
                null,
                null
        );
    }
}
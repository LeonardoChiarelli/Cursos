package br.com.LeoChiarelli.api.domain.appointment.repository;

import br.com.LeoChiarelli.api.domain.appointment.models.Appointment;
import br.com.LeoChiarelli.api.domain.doctor.models.Doctor;
import br.com.LeoChiarelli.api.domain.doctor.models.Specialty;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface IAppointmentRepository extends JpaRepository<Appointment, Long> {

    boolean existsByPacienteIdAndDataBetween(@NotNull Long idPaciente, LocalDateTime primeiroHorario, LocalDateTime ultimoHorario);

    @Query("SELECT m FROM Medico m WHERE m.ativo = true AND m.specialty = :especialidade AND m.id NOT in(SELECT c.medico.id FROM Consulta c WHERE c.data = :data) ORDER BY rand() LIMIT 1")
    Doctor chooseDoctor(Specialty especialidade, LocalDateTime data);

    boolean existsByIdAndData(Long idMedico, LocalDateTime data);
}

package br.com.LeoChiarelli.api.domain.appointment.repository;

import br.com.LeoChiarelli.api.domain.appointment.models.Appointment;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface IAppointmentRepository extends JpaRepository<Appointment, Long> {

    Boolean existsByPacienteIdAndDataBetween(@NotNull Long idPaciente, LocalDateTime primeiroHorario, LocalDateTime ultimoHorario);
}

package br.com.LeoChiarelli.api.domain.appointment.dto;

import java.time.LocalDateTime;

public record AppointmentDetailingDTO(Long id, Long idMedico, Long idPaciente, LocalDateTime data) {
}

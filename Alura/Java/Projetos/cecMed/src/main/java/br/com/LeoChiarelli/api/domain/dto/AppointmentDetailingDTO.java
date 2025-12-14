package br.com.LeoChiarelli.api.domain.dto;

import br.com.LeoChiarelli.api.domain.models.Appointment;

import java.time.LocalDateTime;

public record AppointmentDetailingDTO(Long id, Long idMedico, Long idPaciente, LocalDateTime data) {
    public AppointmentDetailingDTO(Appointment consulta) {
        this(consulta.getId(), consulta.getMedico().getId(), consulta.getPaciente().getId(), consulta.getData());
    }
}

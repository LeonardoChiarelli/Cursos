package br.com.LeoChiarelli.api.domain.appointment.dto;

import br.com.LeoChiarelli.api.domain.appointment.models.Reason;
import jakarta.validation.constraints.NotNull;

public record AppointmentCancelDTO (

        @NotNull
        Long idConsulta,

        @NotNull
        Reason motivo){
}

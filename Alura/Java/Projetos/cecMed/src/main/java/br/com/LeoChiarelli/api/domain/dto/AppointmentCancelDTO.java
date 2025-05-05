package br.com.LeoChiarelli.api.domain.dto;

import br.com.LeoChiarelli.api.domain.models.Reason;
import jakarta.validation.constraints.NotNull;

public record AppointmentCancelDTO (

        @NotNull
        Long idConsulta,

        @NotNull
        Reason motivo){
}

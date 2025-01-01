package br.com.LeoChiarelli.api.domain.dto;

import br.com.LeoChiarelli.api.domain.models.Specialty;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record AppointmentDTO(
        Long idMedico,

        @NotNull
        Long idPaciente,

        @NotNull
        @Future
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
        LocalDateTime data, // Padrão americano (YYYY-MM-DD), porém podemos mudar o padrão como foi feito; utiliza-se o 'T' para separar a hora (HH:MM:SS)

        Specialty especialidade
) {
}

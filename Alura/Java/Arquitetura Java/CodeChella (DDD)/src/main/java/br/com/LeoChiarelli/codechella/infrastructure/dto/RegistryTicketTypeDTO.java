package br.com.LeoChiarelli.codechella.infrastructure.dto;

import br.com.LeoChiarelli.codechella.domain.valueObject.Area;
import br.com.LeoChiarelli.codechella.domain.valueObject.Definition;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record RegistryTicketTypeDTO(

        @NotNull(message = "O setor do ingresso é obrigatório!")
        Area area,

        @NotNull(message = "A definição do tipo de ingresso é obrigatória!")
        Definition definition,

        @NotNull
        Double value,

        @Positive
        int totalAvailable

) {
}

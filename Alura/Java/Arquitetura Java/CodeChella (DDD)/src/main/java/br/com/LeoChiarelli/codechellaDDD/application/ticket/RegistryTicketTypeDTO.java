package br.com.LeoChiarelli.codechellaDDD.application.ticket;

import br.com.LeoChiarelli.codechellaDDD.domain.ticket.valueObject.Area;
import br.com.LeoChiarelli.codechellaDDD.domain.ticket.valueObject.Definition;
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

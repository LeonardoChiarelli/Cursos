package br.com.LeoChiarelli.codechella.infrastructure.dto;

import jakarta.validation.constraints.NotNull;

public record RegistryTicketDTO(

        @NotNull(message = "O código do ingresso é obrigatório!")
        Integer code,

        @NotNull(message = "O id do tipo é obrigatório!")
        Long type_id
) {
}

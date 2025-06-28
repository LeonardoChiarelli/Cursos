package br.com.LeoChiarelli.codechella.infrastructure.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record RegistrySaleDTO(

        @NotNull(message = "O id do usuário é obrigatório!")
        Long user_id,

        @NotNull(message = "Os dados do ingresso devem ser informados")
        @Valid
        List<RegistryTicketDTO> tickets

) {

}

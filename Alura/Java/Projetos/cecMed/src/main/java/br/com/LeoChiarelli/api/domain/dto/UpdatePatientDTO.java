package br.com.LeoChiarelli.api.domain.dto;

import jakarta.validation.constraints.NotNull;

public record UpdatePatientDTO(
        @NotNull
        Long id,

        String nome,
        String telefone,
        AddressDTO endereco) {
}

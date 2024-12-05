package br.com.LeoChiarelli.api.domain.patient.dto;

import br.com.LeoChiarelli.api.domain.address.dto.AddressDTO;
import jakarta.validation.constraints.NotNull;

public record UpdatePatientDTO(
        @NotNull
        Long id,

        String nome,
        String telefone,
        AddressDTO endereco) {
}

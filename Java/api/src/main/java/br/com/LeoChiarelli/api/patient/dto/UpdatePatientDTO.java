package br.com.LeoChiarelli.api.patient.dto;

import br.com.LeoChiarelli.api.general.dto.AddressDTO;
import jakarta.validation.constraints.NotNull;

public record UpdatePatientDTO(
        @NotNull
        Long id,

        String nome,
        String telefone,
        AddressDTO endereco) {
}

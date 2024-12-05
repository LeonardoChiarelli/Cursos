package br.com.LeoChiarelli.api.patient.dto;

import br.com.LeoChiarelli.api.general.dto.AddressDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record PatientDTO(
        @NotBlank
        String nome,

        @NotBlank
        @Email
        String email,

        @NotBlank
        @Pattern(regexp = "\\d{9,11}")
        String telefone,

        @NotBlank
        @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}")
        String cpf,

        @NotNull
        @Valid
        AddressDTO endereco) {
}

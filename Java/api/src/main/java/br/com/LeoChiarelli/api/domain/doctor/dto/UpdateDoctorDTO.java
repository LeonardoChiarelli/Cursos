package br.com.LeoChiarelli.api.domain.doctor.dto;

import br.com.LeoChiarelli.api.domain.address.dto.AddressDTO;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record UpdateDoctorDTO(
        @NotNull
        Long id,
        String nome,

        @Pattern(regexp = "\\d{9,11}")
        String telefone,
        AddressDTO endereco
) {
}

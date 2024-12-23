package br.com.LeoChiarelli.adopet.domain.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record AbrigoDTO(
        Long id,

        @NotBlank
        String nome,

        @NotBlank
        @Pattern(regexp = "\\d{9,11}")
        String telefone,

        @NotBlank
        @Email
        String email,

        @NotNull
        @Valid
        PetDTO pet) {
}

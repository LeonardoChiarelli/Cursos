package br.com.LeoChiarelli.adopet.api.domain.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record CadastrarTutorDTO(
        @NotBlank
        String nome,

        @NotBlank
        @Pattern(regexp = "\\(?\\d{2}\\)?\\d?\\d{5}-?\\d{4}")
        String telefone,

        @NotBlank
        @Email
        String email) {
}

package br.com.LeoChiarelli.adopet.api.domain.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;

public record AtualizarTutorDTO(
        Long id,
        String nome,

        @Pattern(regexp = "\\(?\\d{2}\\)?\\d?\\d{5}-?\\d{4}")
        String telefone,

        @Email
        String email) {
}

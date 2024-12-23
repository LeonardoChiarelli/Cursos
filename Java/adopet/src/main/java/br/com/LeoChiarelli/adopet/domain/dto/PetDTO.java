package br.com.LeoChiarelli.adopet.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record PetDTO(
        Long id,

        @NotBlank
        String tipo,

        @NotBlank
        String nome,

        @NotBlank
        String raca,

        @NotBlank
        @Pattern(regexp = "\\d")
        String idade,

        @NotBlank
        String cor,

        @NotBlank
        @Pattern(regexp = "\\d")
        String peso) {
}

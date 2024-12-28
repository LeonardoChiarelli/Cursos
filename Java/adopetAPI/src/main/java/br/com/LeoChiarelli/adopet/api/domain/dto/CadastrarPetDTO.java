package br.com.LeoChiarelli.adopet.api.domain.dto;

import br.com.LeoChiarelli.adopet.api.domain.model.TipoPet;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CadastrarPetDTO(
        @NotNull
        TipoPet tipoPet,

        @NotBlank
        String nome,

        @NotBlank
        String raca,

        @NotNull
        Integer idade,

        @NotBlank
        String cor,

        @NotNull
        Float peso) {
}

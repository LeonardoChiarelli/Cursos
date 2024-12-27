package br.com.LeoChiarelli.adopet.api.dto;

import br.com.LeoChiarelli.adopet.api.model.Abrigo;
import br.com.LeoChiarelli.adopet.api.model.Adocao;
import br.com.LeoChiarelli.adopet.api.model.TipoPet;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PetDTO(
        @NotBlank
        Long id,

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
        Float peso,

        Boolean adotado,

        @JsonBackReference("abrigo_pets")
        Abrigo abrigo,

        @JsonBackReference("adocao_pets")
        Adocao adocao
) {
}

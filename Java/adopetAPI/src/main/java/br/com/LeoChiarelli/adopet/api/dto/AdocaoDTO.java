package br.com.LeoChiarelli.adopet.api.dto;

import br.com.LeoChiarelli.adopet.api.model.Pet;
import br.com.LeoChiarelli.adopet.api.model.StatusAdocao;
import br.com.LeoChiarelli.adopet.api.model.Tutor;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record AdocaoDTO(
        Long id,
        LocalDateTime data,

        @NotNull
        @JsonBackReference("tutor_adocoes")
        Tutor tutor,

        @NotNull
        @JsonManagedReference("adocao_pets")
        Pet pet,

        @NotBlank
        String motivo,

        StatusAdocao statusAdocao,

        String justificativaStatus
) {
}

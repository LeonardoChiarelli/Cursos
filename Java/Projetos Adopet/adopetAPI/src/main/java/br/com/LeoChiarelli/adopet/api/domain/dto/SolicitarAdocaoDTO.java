package br.com.LeoChiarelli.adopet.api.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record SolicitarAdocaoDTO(@NotNull Long idPet, @NotNull Long idTutor, @NotBlank String motivo) {
}

package br.com.LeoChiarelli.adopet.api.domain.dto;

import jakarta.validation.constraints.NotNull;

public record AprovarAdocaoDTO(@NotNull Long idAdocao) {
}

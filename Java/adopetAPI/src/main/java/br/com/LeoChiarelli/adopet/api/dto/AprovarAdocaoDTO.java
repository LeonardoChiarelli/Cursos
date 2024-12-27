package br.com.LeoChiarelli.adopet.api.dto;

import jakarta.validation.constraints.NotNull;

public record AprovarAdocaoDTO(@NotNull Long idAdocao) {
}

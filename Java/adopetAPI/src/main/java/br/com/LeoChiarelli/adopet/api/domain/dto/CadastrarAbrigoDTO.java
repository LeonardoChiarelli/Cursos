package br.com.LeoChiarelli.adopet.api.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CadastrarAbrigoDTO(Long id, @NotBlank String nome, @NotBlank String telefone, @NotBlank String email) {
}

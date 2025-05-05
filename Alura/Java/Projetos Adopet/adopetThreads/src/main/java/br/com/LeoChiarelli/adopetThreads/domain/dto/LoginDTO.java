package br.com.LeoChiarelli.adopetThreads.domain.dto;

import jakarta.validation.constraints.NotBlank;

public record LoginDTO(@NotBlank String email, @NotBlank String senha) {
}

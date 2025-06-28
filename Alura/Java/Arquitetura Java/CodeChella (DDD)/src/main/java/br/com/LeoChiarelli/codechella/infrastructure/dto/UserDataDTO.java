package br.com.LeoChiarelli.codechella.infrastructure.dto;

import java.time.LocalDate;

public record UserDataDTO(
        Long id,
        String cpf,
        String nome,
        LocalDate nascimento,
        String email
) {
}

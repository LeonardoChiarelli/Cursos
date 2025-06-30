package br.com.LeoChiarelli.codechellaDDD.application.user;

import java.time.LocalDate;

public record UserDataDTO(
        Long id,
        String cpf,
        String nome,
        LocalDate nascimento,
        String email
) {
}

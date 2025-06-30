package br.com.LeoChiarelli.codechellaTDD.infrastructure.dto;

import java.time.LocalDate;

public record UserRegistryRequestDTO(

        String ssn,
        String name,
        LocalDate birth,
        String email
) {
}

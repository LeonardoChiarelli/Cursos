package br.com.LeoChiarelli.codechellaAPI.domain.authentication.valueObject;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

public record RegistryUserDataDTO(
        @NotBlank(message = "User name is require!")
        String name,

        @NotBlank(message = "User ssn is require!")
        @CPF(message = "Invalid SSN format!")
        String ssn,

        @NotBlank(message = "User email is require!")
        @Email(message = "Invalid email format!")
        String email,

        @NotNull(message = "User birth is require!")
        LocalDate birth) {
}

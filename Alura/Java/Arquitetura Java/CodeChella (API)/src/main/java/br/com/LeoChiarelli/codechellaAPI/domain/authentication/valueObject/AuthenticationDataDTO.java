package br.com.LeoChiarelli.codechellaAPI.domain.authentication.valueObject;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record AuthenticationDataDTO(
        @NotBlank(message = "Email is required to perform the authentication!")
        @Email(message = "Invalid email format!")
        String email,

        @NotBlank(message = "Password is require to perform the authentication!")
        String password) {}

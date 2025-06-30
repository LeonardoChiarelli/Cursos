package br.com.LeoChiarelli.codechellaDDD.application.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record RegistryUserDTO(

         @NotBlank(message = "O cpf é obrigatório!")
         String ssn,

         @NotBlank(message = "O nome é obrigatório!")
         String name,

         @NotNull(message = "A data de nascimento é obrigatória!")
         LocalDate birth,

         @NotBlank(message = "O e-mail é obrigatório!")
         String email
) {
}

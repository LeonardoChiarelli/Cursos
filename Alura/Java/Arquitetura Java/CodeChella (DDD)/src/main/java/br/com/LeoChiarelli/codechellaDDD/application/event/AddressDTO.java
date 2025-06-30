package br.com.LeoChiarelli.codechellaDDD.application.event;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record AddressDTO(

        @NotBlank(message = "O cep é obrigatório!")
        String postalCode,

        @NotNull
        @Positive(message = "O número do endereço é obrigatório!")
        Integer number,

        String complement
) {
}

package br.com.LeoChiarelli.api.domain.doctor.dto;

import br.com.LeoChiarelli.api.domain.address.dto.AddressDTO;
import br.com.LeoChiarelli.api.domain.doctor.models.Specialty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DoctorDTO( // Usamos o 'Bean Validation' no DTO pois é onde os dados estão chegando
        Long id,

        @NotBlank // Para verificar se o campo não esta vazio ou nulo
        String nome,

        @NotBlank
        @Email // Para validação de email
        String email,

        @NotBlank
        @Pattern(regexp = "\\d{9,11}")
        String telefone,

        @NotBlank
        @Pattern(regexp = "\\d{4,6}") // '\\d' para indicar que é um dígito, '{4,6}' para indicar que são de 4 até 6 dígitos
        String crm,

        @NotNull// NotNull pois não é uma String
        Specialty especialidade,

        @NotNull
        @Valid // Para indicar que dentro de um DTO existe outro DTO que também precisa ser valido
        AddressDTO endereco){
}

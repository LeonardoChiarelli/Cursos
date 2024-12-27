package br.com.LeoChiarelli.adopet.api.dto;

import br.com.LeoChiarelli.adopet.api.model.Adocao;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.util.List;

public record TutorDTO(
        @NotBlank
        Long id,

        @NotBlank
        String nome,

        @NotBlank
        @Pattern(regexp = "\\(?\\d{2}\\)?\\d?\\d{4}-?\\d{4}")
        String telefone,

        @NotBlank
        @Email
        String email,

        @JsonManagedReference("tutor_adocoes")
        List<Adocao> adocoes
) {
}

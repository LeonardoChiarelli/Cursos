package br.com.LeoChiarelli.adopet.api.domain.dto;

import br.com.LeoChiarelli.adopet.api.domain.model.Abrigo;
import br.com.LeoChiarelli.adopet.api.domain.model.Pet;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.util.List;

public record AbrigoDTO(
        @NotBlank
        Long id,

        @NotBlank
        String nome,

        @NotBlank
        @Pattern(regexp = "\\(?\\d{2}\\)?\\d?\\d{4}-?\\d{4}")
        String telefone,

        @NotBlank
        @Email
        String email
) {
        public AbrigoDTO(Abrigo abrigo){
                this(abrigo.getId(), abrigo.getNome(), abrigo.getTelefone(), abrigo.getEmail());
        }
}
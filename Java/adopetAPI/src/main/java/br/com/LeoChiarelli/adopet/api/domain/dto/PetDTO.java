package br.com.LeoChiarelli.adopet.api.domain.dto;

import br.com.LeoChiarelli.adopet.api.domain.model.Abrigo;
import br.com.LeoChiarelli.adopet.api.domain.model.Adocao;
import br.com.LeoChiarelli.adopet.api.domain.model.Pet;
import br.com.LeoChiarelli.adopet.api.domain.model.TipoPet;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PetDTO(
        @NotBlank
        Long id,

        @NotNull
        TipoPet tipoPet,

        @NotBlank
        String nome,

        @NotBlank
        String raca,

        @NotNull
        Integer idade,

        @NotBlank
        String cor
) {
        public PetDTO(Pet pet){
                this(pet.getId(), pet.getTipo(), pet.getNome(), pet.getRaca(), pet.getIdade(), pet.getCor());
        }
}

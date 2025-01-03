package adopet.api.domain.dto;

import adopet.api.domain.model.Pet;
import adopet.api.domain.model.TipoPet;

public record PetDTO(Long id, String nome, Integer idade, TipoPet tipo, Boolean adotado, String imagem) {

    public PetDTO(Pet pet){

        this(pet.getId(), pet.getNome(), pet.getIdade(), pet.getTipo(), pet.getAdotado(), pet.getImagem());
    }
}

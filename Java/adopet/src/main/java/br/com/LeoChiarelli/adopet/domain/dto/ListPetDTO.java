package br.com.LeoChiarelli.adopet.domain.dto;

import br.com.LeoChiarelli.adopet.domain.models.Pet;

public record ListPetDTO(
        Long id,
        String tipo,
        String nome,
        String raca,
        String idade,
        String cor,
        String peso
) {
    public ListPetDTO(Pet pet) {
        this(pet.getId(), pet.getTipo(), pet.getNome(), pet.getRaca(), pet.getIdade(), pet.getCor(), pet.getPeso());
    }
}

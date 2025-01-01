package adopet.api.domain.dto;

import adopet.api.domain.model.Tutor;

public record TutorDTO(Long id, String nome, String email) {

    public TutorDTO(Tutor tutor){
        this(tutor.getId(), tutor.getNome(), tutor.getEmail());
    }
}

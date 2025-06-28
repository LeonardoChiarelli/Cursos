package br.com.LeoChiarelli.codechella.infrastructure.dto;

import br.com.LeoChiarelli.codechella.domain.entities.user.User;

public record UserResponseDTO(
        String name,
        String email
) {
    public UserResponseDTO(User user){
        this(user.getName(), user.getEmail());
    }
}

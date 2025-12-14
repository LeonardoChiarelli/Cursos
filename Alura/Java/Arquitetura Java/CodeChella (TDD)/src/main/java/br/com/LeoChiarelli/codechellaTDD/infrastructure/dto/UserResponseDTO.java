package br.com.LeoChiarelli.codechellaTDD.infrastructure.dto;

import br.com.LeoChiarelli.codechellaTDD.domain.entities.user.User;

public record UserResponseDTO(
        String name,
        String email
) {
    public UserResponseDTO(User user){
        this(user.getName(), user.getEmail());
    }
}

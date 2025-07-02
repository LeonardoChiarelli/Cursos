package br.com.LeoChiarelli.codechellaAPI.domain.authentication.valueObject;

import br.com.LeoChiarelli.codechellaAPI.domain.authentication.entity.User;

import java.time.LocalDate;

public record UserDataDTO(Long id, String name, String ssn, String email, LocalDate birth) {

    public UserDataDTO(User user) {
        this(user.getId(), user.getName(), user.getSsn(), user.getEmail(), user.getBirth());
    }

}

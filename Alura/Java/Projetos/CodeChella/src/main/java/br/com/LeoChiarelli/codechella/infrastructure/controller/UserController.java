package br.com.LeoChiarelli.codechella.infrastructure.controller;

import br.com.LeoChiarelli.codechella.application.useCases.RegistryUserImplementation;
import br.com.LeoChiarelli.codechella.domain.entities.user.User;
import br.com.LeoChiarelli.codechella.infrastructure.dto.UserRequestDTO;
import br.com.LeoChiarelli.codechella.infrastructure.dto.UserResponseDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final RegistryUserImplementation registryUser;

    public UserController(RegistryUserImplementation registryUser) {
        this.registryUser = registryUser;
    }

    @PostMapping()
    public UserResponseDTO registryUser(@RequestBody UserRequestDTO dto) {
        return new UserResponseDTO(registryUser.registryUser(new User(dto.ssn(), dto.name(), dto.birth(), dto.email())));
    }
}

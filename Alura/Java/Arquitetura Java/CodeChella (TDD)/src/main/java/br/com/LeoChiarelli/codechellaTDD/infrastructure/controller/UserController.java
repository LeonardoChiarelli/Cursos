package br.com.LeoChiarelli.codechellaTDD.infrastructure.controller;

import br.com.LeoChiarelli.codechellaTDD.application.useCases.DeleteUserImplementation;
import br.com.LeoChiarelli.codechellaTDD.application.useCases.ListUsersImplementation;
import br.com.LeoChiarelli.codechellaTDD.application.useCases.RegistryUserImplementation;
import br.com.LeoChiarelli.codechellaTDD.application.useCases.UpdateUserImplementation;
import br.com.LeoChiarelli.codechellaTDD.domain.entities.user.User;
import br.com.LeoChiarelli.codechellaTDD.infrastructure.dto.UserRegistryRequestDTO;
import br.com.LeoChiarelli.codechellaTDD.infrastructure.dto.UserResponseDTO;
import br.com.LeoChiarelli.codechellaTDD.infrastructure.dto.UserUpdateRequestDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final RegistryUserImplementation registryUser;
    private final ListUsersImplementation listUsers;
    private final UpdateUserImplementation updateUser;
    private final DeleteUserImplementation deleteUser;

    public UserController(RegistryUserImplementation registryUser, ListUsersImplementation listUsers, UpdateUserImplementation updateUser, DeleteUserImplementation deleteUser) {
        this.registryUser = registryUser;
        this.listUsers = listUsers;
        this.updateUser = updateUser;
        this.deleteUser = deleteUser;
    }

    @PostMapping()
    public UserResponseDTO registryUser(@RequestBody UserRegistryRequestDTO dto) {
        return new UserResponseDTO(registryUser.registryUser(new User(dto.ssn(), dto.name(), dto.birth(), dto.email())));
    }

    @GetMapping()
    public List<UserResponseDTO> listAll() {
        return listUsers.listAll().stream()
                .map(UserResponseDTO::new)
                .toList();
    }

    @PatchMapping()
    public UserResponseDTO updateUser(@RequestBody UserUpdateRequestDTO dto) {
        return new UserResponseDTO(updateUser.updateUser(dto.ssn(), dto.email()));
    }

    @DeleteMapping("/{ssn}")
    public void deleteUser(@PathVariable String ssn) {
        deleteUser.deleteUser(ssn);
    }
}

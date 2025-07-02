package br.com.LeoChiarelli.codechellaAPI.controller;

import br.com.LeoChiarelli.codechellaAPI.domain.authentication.service.RegistryUserService;
import br.com.LeoChiarelli.codechellaAPI.domain.authentication.valueObject.RegistryUserDataDTO;
import br.com.LeoChiarelli.codechellaAPI.domain.authentication.valueObject.UserDataDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/users")
public class UserController {

    private final RegistryUserService registryUserService;

    public UserController(RegistryUserService registryUserService) {
        this.registryUserService = registryUserService;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<UserDataDTO> registry(@RequestBody @Valid RegistryUserDataDTO dto, UriComponentsBuilder uriComponentsBuilder) {
        var registeredUserData = registryUserService.registryUser(dto);
        var uri = uriComponentsBuilder.path("/users/{id}").buildAndExpand(registeredUserData.id()).toUri();
        return ResponseEntity.created(uri).body(registeredUserData);
    }

}

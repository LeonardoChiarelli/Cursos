package br.com.LeoChiarelli.codechellaDDD.application.user;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    @Transactional
    public ResponseEntity<UserDataDTO> cadastrar(@RequestBody @Valid RegistryUserDTO dadosUsuario, UriComponentsBuilder uriBuilder) {
        UserDataDTO usuarioSalvo = service.registryUser(dadosUsuario);
        var uri = uriBuilder.path("/usuarios/{id}").buildAndExpand(usuarioSalvo.id()).toUri();

        return ResponseEntity.created(uri).body(usuarioSalvo);
    }

    @GetMapping
    public ResponseEntity<List<UserDataDTO>> listar() {
        return ResponseEntity.ok(service.listAll());
    }

}

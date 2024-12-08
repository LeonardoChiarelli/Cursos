package br.com.LeoChiarelli.api.domain.user.controller;

import br.com.LeoChiarelli.api.domain.user.dto.UserDTO;
import br.com.LeoChiarelli.api.domain.user.models.User;
import br.com.LeoChiarelli.api.general.infra.security.TokenJWTDataDTO;
import br.com.LeoChiarelli.api.general.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class UserController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity login(@RequestBody @Valid UserDTO data){
        var token = new UsernamePasswordAuthenticationToken(data.login(), data.senha());
        var authentication = manager.authenticate(token);

        var tokenClient = tokenService.generateToken((User) authentication.getPrincipal());
        return ResponseEntity.ok(new TokenJWTDataDTO(tokenClient));
    }
}

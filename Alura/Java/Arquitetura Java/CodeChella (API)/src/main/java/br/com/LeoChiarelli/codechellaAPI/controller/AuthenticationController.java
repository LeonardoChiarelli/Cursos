package br.com.LeoChiarelli.codechellaAPI.controller;

import br.com.LeoChiarelli.codechellaAPI.domain.authentication.entity.User;
import br.com.LeoChiarelli.codechellaAPI.domain.authentication.valueObject.AuthenticationDataDTO;
import br.com.LeoChiarelli.codechellaAPI.domain.authentication.valueObject.TokenJWTDataDTO;
import br.com.LeoChiarelli.codechellaAPI.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthenticationManager manager;
    private final TokenService tokenService;

    public AuthenticationController(AuthenticationManager manager, TokenService tokenService) {
        this.manager = manager;
        this.tokenService = tokenService;
    }

    @PostMapping
    public ResponseEntity<TokenJWTDataDTO> LogIn(@RequestBody @Valid AuthenticationDataDTO dados) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(dados.email(), dados.password());
        var authentication = manager.authenticate(authenticationToken);

        var tokenJWT = tokenService.generateToken((User) authentication.getPrincipal());

        return ResponseEntity.ok(new TokenJWTDataDTO("Bearer", tokenJWT));
    }

}

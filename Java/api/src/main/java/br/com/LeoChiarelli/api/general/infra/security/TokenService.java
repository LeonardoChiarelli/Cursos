package br.com.LeoChiarelli.api.general.infra.security;

import br.com.LeoChiarelli.api.domain.user.models.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    public String generateToken(User usuario){
        try{
            var algoritmo = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("API CEC.med")
                    .withSubject(usuario.getLogin())
                    .withClaim("id", usuario.getId())
                    .withExpiresAt(expirationDate())
                    .sign(algoritmo);
        } catch (JWTCreationException e){
            throw new RuntimeException("erro ao gerar o token JWT", e);
        }
    }

    private Instant expirationDate() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}

// É recomendado configurar uma data de expiração para tokens
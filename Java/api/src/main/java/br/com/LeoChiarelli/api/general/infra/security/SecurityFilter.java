package br.com.LeoChiarelli.api.general.infra.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component // Usado quando queremos que o spring carregue uma classe mas ela não tem um tipo específico, espécie de classe genérica
public class SecurityFilter extends OncePerRequestFilter {


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        var tokenJWT = recoverToken(request);

        System.out.println(tokenJWT);

        filterChain.doFilter(request, response); // necessário para chamar os próximos filtros na aplicação
    }

    private String recoverToken(HttpServletRequest request) {
        var authorizationHeader = request.getHeader("Authorization");

        if (authorizationHeader == null){
            throw new RuntimeException("TokenJWT não enviado no cabeçalho Authorization");
        }
        return authorizationHeader.replace("Bearer ", " ");
    }
}

// FilterChain - representa a cadeia de filttos na aplicação

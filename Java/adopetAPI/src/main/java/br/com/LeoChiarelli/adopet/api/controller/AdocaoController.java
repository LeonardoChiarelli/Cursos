package br.com.LeoChiarelli.adopet.api.controller;

import br.com.LeoChiarelli.adopet.api.dto.AprovarAdocaoDTO;
import br.com.LeoChiarelli.adopet.api.dto.ReprovarAdocaoDTO;
import br.com.LeoChiarelli.adopet.api.dto.SolicitarAdocaoDTO;
import br.com.LeoChiarelli.adopet.api.exception.ValidacaoException;
import br.com.LeoChiarelli.adopet.api.service.AdocaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/adocoes")
public class AdocaoController {

    @Autowired
    protected AdocaoService service;

    @PostMapping
    @Transactional
    public ResponseEntity<String> solicitar(@RequestBody @Valid SolicitarAdocaoDTO adocao) {
        try {
            service.solicitar(adocao);
            return ResponseEntity.ok("Adoção solicitada com sucesso!");
        } catch (ValidacaoException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/aprovar")
    @Transactional
    public ResponseEntity<String> aprovar(@RequestBody @Valid AprovarAdocaoDTO adocao) {
        service.aprovar(adocao);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/reprovar")
    @Transactional
    public ResponseEntity<String> reprovar(@RequestBody @Valid ReprovarAdocaoDTO adocao) {
        service.reprovar(adocao);
        return ResponseEntity.ok().build();
    }

}

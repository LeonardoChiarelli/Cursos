package br.com.LeoChiarelli.adopet.api.domain.controller;

import br.com.LeoChiarelli.adopet.api.domain.dto.AtualizarTutorDTO;
import br.com.LeoChiarelli.adopet.api.domain.dto.CadastrarTutorDTO;
import br.com.LeoChiarelli.adopet.api.domain.service.TutorService;
import br.com.LeoChiarelli.adopet.api.general.exception.ValidacaoException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tutores")
public class TutorController {

    @Autowired
    private TutorService service;

    @PostMapping
    @Transactional
    public ResponseEntity<String> cadastrar(@RequestBody @Valid CadastrarTutorDTO tutor) {
        try{
            service.cadastrar(tutor);
            return ResponseEntity.ok().build();
        } catch (ValidacaoException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping
    @Transactional
    public ResponseEntity<String> atualizar(@RequestBody @Valid AtualizarTutorDTO tutor) {
        try{
            service.atualizar(tutor);
            return ResponseEntity.ok().build();
        } catch (ValidacaoException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}

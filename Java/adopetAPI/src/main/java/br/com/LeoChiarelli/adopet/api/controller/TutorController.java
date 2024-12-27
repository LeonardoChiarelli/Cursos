package br.com.LeoChiarelli.adopet.api.controller;

import br.com.LeoChiarelli.adopet.api.dto.TutorDTO;
import br.com.LeoChiarelli.adopet.api.service.TutorService;
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
    public ResponseEntity<String> cadastrar(@RequestBody @Valid TutorDTO tutor) {
        service.cadastrar(tutor);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity<String> atualizar(@RequestBody @Valid TutorDTO tutor) {
        service.atualizar(tutor);
        return ResponseEntity.ok().build();
    }

}

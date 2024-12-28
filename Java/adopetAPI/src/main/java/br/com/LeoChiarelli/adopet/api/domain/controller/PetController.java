package br.com.LeoChiarelli.adopet.api.domain.controller;

import br.com.LeoChiarelli.adopet.api.domain.dto.PetDTO;
import br.com.LeoChiarelli.adopet.api.domain.model.Pet;
import br.com.LeoChiarelli.adopet.api.domain.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private PetService service;

    @GetMapping
    public ResponseEntity<List<PetDTO>> listarTodosDisponiveis() {
        List<PetDTO> disponiveis = service.listarTodosDisponiveis();
        return ResponseEntity.ok(disponiveis);
    }
}

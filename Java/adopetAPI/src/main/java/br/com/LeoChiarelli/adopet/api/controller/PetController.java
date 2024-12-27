package br.com.LeoChiarelli.adopet.api.controller;

import br.com.LeoChiarelli.adopet.api.model.Pet;
import br.com.LeoChiarelli.adopet.api.repository.PetRepository;
import br.com.LeoChiarelli.adopet.api.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetController {

    @Autowired
    protected PetService service;

    @GetMapping
    public ResponseEntity<List<Pet>> listarTodosDisponiveis() {
        var disponiveis = service.listarTodosDisponiveis();
        return ResponseEntity.ok(disponiveis);
    }
}

package br.com.LeoChiarelli.adopet.api.controller;

import br.com.LeoChiarelli.adopet.api.dto.AbrigoDTO;
import br.com.LeoChiarelli.adopet.api.dto.CadastrarAbrigoDTO;
import br.com.LeoChiarelli.adopet.api.model.Abrigo;
import br.com.LeoChiarelli.adopet.api.model.Pet;
import br.com.LeoChiarelli.adopet.api.service.AbrigoService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/abrigos")
public class AbrigoController {

    @Autowired
    protected AbrigoService service;

    @GetMapping
    public ResponseEntity<List<Abrigo>> listar() {
        var list = service.listar();
        return ResponseEntity.ok(list);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<String> cadastrar(@RequestBody @Valid CadastrarAbrigoDTO abrigo) {
        service.cadastrar(abrigo);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{idOuNome}/pets")
    public ResponseEntity<List<Pet>> listarPets(@PathVariable String idOuNome) {
        try {
            var pets = service.listarPets(idOuNome);
            return ResponseEntity.ok(pets);
        } catch (EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{idOuNome}/pets")
    @Transactional
    public ResponseEntity<String> cadastrarPet(@PathVariable String idOuNome, @RequestBody @Valid Pet pet) {
        try {
            service.cadastrarPet(idOuNome, pet);
            return ResponseEntity.ok().build();
        } catch (EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }
}

package br.com.LeoChiarelli.adopet.api.domain.controller;

import br.com.LeoChiarelli.adopet.api.domain.dto.AbrigoDTO;
import br.com.LeoChiarelli.adopet.api.domain.dto.CadastrarAbrigoDTO;
import br.com.LeoChiarelli.adopet.api.domain.dto.CadastrarPetDTO;
import br.com.LeoChiarelli.adopet.api.domain.dto.PetDTO;
import br.com.LeoChiarelli.adopet.api.domain.service.AbrigoService;
import br.com.LeoChiarelli.adopet.api.domain.service.PetService;
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
    private AbrigoService service;

    @Autowired
    private PetService petService;

    @GetMapping
    public ResponseEntity<List<AbrigoDTO>> listar() {
        List<AbrigoDTO> list = service.listar();
        return ResponseEntity.ok(list);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<String> cadastrar(@RequestBody @Valid CadastrarAbrigoDTO abrigo) {
        service.cadastrar(abrigo);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{idOuNome}/pets")
    public ResponseEntity<List<PetDTO>> listarPets(@PathVariable String idOuNome) {
        try {
            var pets = service.listarPets(idOuNome);
            return ResponseEntity.ok(pets);
        } catch (EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{idOuNome}/pets")
    @Transactional
    public ResponseEntity<String> cadastrarPet(@PathVariable String idOuNome, @RequestBody @Valid CadastrarPetDTO pet) {
        try {
            var abrigo = service.carregarAbrigo(idOuNome);
            petService.cadastrarPet(abrigo, pet);
            return ResponseEntity.ok().build();
        } catch (EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }
}

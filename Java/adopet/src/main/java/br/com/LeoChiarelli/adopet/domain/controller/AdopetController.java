package br.com.LeoChiarelli.adopet.domain.controller;

import br.com.LeoChiarelli.adopet.domain.dto.*;
import br.com.LeoChiarelli.adopet.domain.models.Abrigo;
import br.com.LeoChiarelli.adopet.domain.models.Pet;
import br.com.LeoChiarelli.adopet.domain.repository.IAbrigoRepository;
import br.com.LeoChiarelli.adopet.domain.repository.IPetRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/abrigos")
public class AdopetController {

    @Autowired
    protected IAbrigoRepository repository;

    @Autowired
    protected IPetRepository petRepository;


    @PostMapping
    @Transactional
    public ResponseEntity cadastrarNovoAbrigo(@RequestBody @Valid AbrigoDTO data, UriComponentsBuilder uriBuilder){
        var abrigo = new Abrigo(data);
        repository.save(abrigo);

        var uri = uriBuilder.path("/abrigos/{id}").buildAndExpand(abrigo.getId()).toUri();

        return ResponseEntity.created(uri).body(new AbrigoDetalhamentoDTO(abrigo));
    }

    @PostMapping("/{id}/pets")
    @Transactional
    public ResponseEntity cadastrarPetsNoAbrigo(@RequestBody @Valid @PathVariable Long id, PetDTO data, UriComponentsBuilder uriBuilder){
        var pet = new Pet(data);
        petRepository.save(pet);
    }

    @GetMapping
    public ResponseEntity<Page<ListAbrigoDTO>> listarAbrigosCadastrados(@PageableDefault(sort = {"id"}) Pageable pageable){
        var page = repository.findAll(pageable).map(ListAbrigoDTO::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalharAbrigo(@PathVariable Long id){
        var abrigo = repository.getReferenceById(id);
        return ResponseEntity.ok(new AbrigoDetalhamentoDTO(abrigo));
    }

    @GetMapping("/{id}/pets")
    public ResponseEntity<Page<ListPetDTO>> listarPetsDoAbrigo(@PageableDefault(sort = {"nome"}) @PathVariable Long id){
        var list = petRepository.findAllPets(id).map(ListPetDTO::new);
        return ResponseEntity.ok(list);
    }
}

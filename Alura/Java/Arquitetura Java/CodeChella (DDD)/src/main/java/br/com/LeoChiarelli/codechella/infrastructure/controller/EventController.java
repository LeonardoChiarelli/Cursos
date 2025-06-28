package br.com.LeoChiarelli.codechella.infrastructure.controller;

import br.com.LeoChiarelli.codechella.infrastructure.gatewaysArrumar.EventService;
import br.com.LeoChiarelli.codechella.infrastructure.dto.RegistryEventDTO;
import br.com.LeoChiarelli.codechella.infrastructure.dto.EventDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventService service;

    @PostMapping
    @Transactional
    public ResponseEntity<EventDTO> cadastrar(@RequestBody @Valid RegistryEventDTO dadosCadastro, UriComponentsBuilder uriBuilder) {
        EventDTO eventDTO = service.registryEvent(dadosCadastro);
        var uri = uriBuilder.path("/eventos/{id}").buildAndExpand(eventDTO.id()).toUri();
        return ResponseEntity.created(uri).body(eventDTO);
    }

    @GetMapping
    public ResponseEntity<List<EventDTO>> listar() {
        return ResponseEntity.ok(service.listAll());
    }

}

package br.com.LeoChiarelli.codechellaAPI.controller;

import br.com.LeoChiarelli.codechellaAPI.domain.event.service.EventService;
import br.com.LeoChiarelli.codechellaAPI.domain.event.valueObject.RegistryEventDataDTO;
import br.com.LeoChiarelli.codechellaAPI.domain.event.valueObject.EventDataDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    private final EventService service;

    public EventController(EventService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<EventDataDTO>> listUpcomingEvents() {
        var upcomingEvents = service.listUpcomingEvents();
        return ResponseEntity.ok(upcomingEvents);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventDataDTO> detail(@PathVariable Long id) {
        var event = service.detail(id);
        return ResponseEntity.ok(event);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<EventDataDTO> registry(@RequestBody @Valid RegistryEventDataDTO dto, UriComponentsBuilder uriBuilder) {
        var eventData = service.registry(dto);
        var uri = uriBuilder.path("/eventos/{id}").buildAndExpand(eventData.id()).toUri();
        return ResponseEntity.created(uri).body(eventData);
    }

}

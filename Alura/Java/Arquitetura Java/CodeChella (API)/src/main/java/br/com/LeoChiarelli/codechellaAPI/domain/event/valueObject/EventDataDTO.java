package br.com.LeoChiarelli.codechellaAPI.domain.event.valueObject;

import br.com.LeoChiarelli.codechellaAPI.domain.event.entity.Event;

import java.time.LocalDateTime;

public record EventDataDTO(Long id, String name, String description, LocalDateTime date, EventCategory category, Address address) {

    public EventDataDTO(Event event) {
        this(event.getId(), event.getName(), event.getDescription(), event.getDate(), event.getCategory(), event.getEndereco());
    }

}

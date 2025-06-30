package br.com.LeoChiarelli.codechellaDDD.infrastructure.event.gateways;

import br.com.LeoChiarelli.codechellaDDD.domain.event.Event;
import br.com.LeoChiarelli.codechellaDDD.infrastructure.event.EventEntity;
import br.com.LeoChiarelli.codechellaDDD.infrastructure.ticket.gateways.TicketTypeEntityMapper;

public class EventEntityMapper {

    public EventEntity toEntity(Event eventDomain) {
        return new EventEntity(eventDomain.getCategory(), eventDomain.getDescription(), AddressEntityMapper.toEntity(eventDomain.getAddress()), eventDomain.getDate(), TicketTypeEntityMapper.toEntity(eventDomain.getTicketTypes()));
    }

    public Event toDomain(EventEntity eventEntity) {
        return Event.builder()
                .withCategory(eventEntity.getCategory())
                .withDescription(eventEntity.getDescription())
                .withAddress(AddressEntityMapper.toDomain(eventEntity.getAddress()).getPostalCode(), AddressEntityMapper.toDomain(eventEntity.getAddress()).getNumber(), AddressEntityMapper.toDomain(eventEntity.getAddress()).getComplement())
                .withDate(eventEntity.getDate())
                .build();
    }
}

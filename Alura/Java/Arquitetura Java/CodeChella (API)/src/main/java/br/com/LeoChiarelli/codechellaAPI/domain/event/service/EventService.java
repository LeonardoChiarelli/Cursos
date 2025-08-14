package br.com.LeoChiarelli.codechellaAPI.domain.event.service;

import br.com.LeoChiarelli.codechellaAPI.domain.BusinessRuleException;
import br.com.LeoChiarelli.codechellaAPI.domain.event.entity.Event;
import br.com.LeoChiarelli.codechellaAPI.domain.event.entity.Ticket;
import br.com.LeoChiarelli.codechellaAPI.domain.event.repository.EventRepository;
import br.com.LeoChiarelli.codechellaAPI.domain.event.valueObject.RegistryEventDataDTO;
import br.com.LeoChiarelli.codechellaAPI.domain.event.valueObject.RegistryTicketDataDTO;
import br.com.LeoChiarelli.codechellaAPI.domain.event.valueObject.EventDataDTO;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Service
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Cacheable(value = "UpcomingEvents")
    public List<EventDataDTO> listUpcomingEvents() {
        var upcomingEvent = eventRepository.findAllByDateAfter(LocalDateTime.now());
        return upcomingEvent.stream().map(EventDataDTO::new).toList();
    }

    @CacheEvict(value = "UpcomingEvents", allEntries = true)
    public EventDataDTO registry(RegistryEventDataDTO dto) {
        var registeredEvent = eventRepository.existsByNameIgnoringCase(dto.name());
        if (registeredEvent) {
            throw new BusinessRuleException("Event already registered with this name!");
        }

        var tickets = createTicket(dto.tickets());
        var event = new Event(dto, tickets);
        this.eventRepository.save(event);

        return new EventDataDTO(event);
    }

    public EventDataDTO detail(Long id) {
        var event = eventRepository.findById(id).orElseThrow(() -> new BusinessRuleException("Event not found."));
        return new EventDataDTO(event);
    }

    private List<Ticket> createTicket(List<RegistryTicketDataDTO> dto) {
        var tickets = new ArrayList<Ticket>();

        dto.forEach(data -> {
            IntStream.range(0, data.quantity()).forEach(i -> {
                tickets.add(new Ticket(data.description(), data.value()));
            });
        });

        return tickets;
    }

}

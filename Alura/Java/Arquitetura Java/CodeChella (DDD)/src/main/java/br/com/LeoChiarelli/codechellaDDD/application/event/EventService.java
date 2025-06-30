package br.com.LeoChiarelli.codechellaDDD.application.event;

import br.com.LeoChiarelli.codechellaDDD.application.ticket.RegistryTicketTypeDTO;
import br.com.LeoChiarelli.codechellaDDD.infrastructure.event.EventEntity;
import br.com.LeoChiarelli.codechellaDDD.infrastructure.event.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventService {

    @Autowired
    private EventRepository repository;

    public EventDTO registryEvent(RegistryEventDTO dto) {
        var evento = new EventEntity(dto);
        repository.save(evento);
        return convertData(evento);
    }

    public List<EventDTO> listAll() {
        List<EventEntity> eventEntities = repository.findAll();
        return eventEntities.stream()
                .map(this::convertData)
                .collect(Collectors.toList());
    }

    private EventDTO convertData(EventEntity eventEntity) {
        List<RegistryTicketTypeDTO> dadosIngressos = eventEntity.getTicketType().stream()
                .map(i -> new RegistryTicketTypeDTO(i.getArea(), i.getDefinition(),
                        i.getValue(), i.getTotalAvailable()))
                .collect(Collectors.toList());

        return new EventDTO(eventEntity.getId(), eventEntity.getCategory(),
                eventEntity.getDescription(), new AddressDTO(eventEntity.getEndereco().getPostalCode(),
                eventEntity.getEndereco().getNumber(), eventEntity.getEndereco().getComplement()),
                eventEntity.getDate(), dadosIngressos);

    }
}

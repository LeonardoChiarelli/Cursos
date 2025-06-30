package br.com.LeoChiarelli.codechellaDDD.application.event;

import br.com.LeoChiarelli.codechellaDDD.domain.event.Category;
import br.com.LeoChiarelli.codechellaDDD.application.ticket.RegistryTicketTypeDTO;

import java.time.LocalDateTime;
import java.util.List;

public record EventDTO(

        Long id,
        Category category,
        String description,
        AddressDTO address,
        LocalDateTime date,
        List<RegistryTicketTypeDTO> ticketType
) {
}

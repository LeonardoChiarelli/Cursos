package br.com.LeoChiarelli.codechella.infrastructure.dto;

import br.com.LeoChiarelli.codechella.domain.valueObject.Category;

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

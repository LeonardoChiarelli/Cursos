package br.com.LeoChiarelli.codechella.infrastructure.dto;

import br.com.LeoChiarelli.codechella.domain.valueObject.Area;
import br.com.LeoChiarelli.codechella.domain.valueObject.Definition;

public record TicketTypeDataDTO(

        Integer codigo,
        Area area,
        Definition definition
) {
}

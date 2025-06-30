package br.com.LeoChiarelli.codechellaDDD.application.ticket;

import br.com.LeoChiarelli.codechellaDDD.domain.ticket.valueObject.Area;
import br.com.LeoChiarelli.codechellaDDD.domain.ticket.valueObject.Definition;

public record TicketTypeDataDTO(

        Integer codigo,
        Area area,
        Definition definition
) {
}

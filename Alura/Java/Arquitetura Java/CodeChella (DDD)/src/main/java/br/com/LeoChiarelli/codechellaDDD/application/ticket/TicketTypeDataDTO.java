package br.com.LeoChiarelli.codechellaDDD.application.ticket;

import br.com.LeoChiarelli.codechellaDDD.domain.ticket.Area;
import br.com.LeoChiarelli.codechellaDDD.domain.ticket.Definition;

public record TicketTypeDataDTO(

        Integer codigo,
        Area area,
        Definition definition
) {
}

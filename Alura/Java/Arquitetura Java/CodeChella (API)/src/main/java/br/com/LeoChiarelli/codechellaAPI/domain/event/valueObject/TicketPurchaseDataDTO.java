package br.com.LeoChiarelli.codechellaAPI.domain.event.valueObject;

import br.com.LeoChiarelli.codechellaAPI.domain.event.entity.Ticket;

import java.math.BigDecimal;

public record TicketPurchaseDataDTO(String code, String description, BigDecimal value, TicketType type) {

    public TicketPurchaseDataDTO(Ticket ticket) {
        this(ticket.getCode(), ticket.getDescription(), ticket.getValue(), ticket.getType());
    }

}

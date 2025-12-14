package br.com.LeoChiarelli.codechellaDDD.infrastructure.ticket.gateways;

import br.com.LeoChiarelli.codechellaDDD.domain.ticket.Ticket;
import br.com.LeoChiarelli.codechellaDDD.domain.ticket.Type;
import br.com.LeoChiarelli.codechellaDDD.infrastructure.ticket.TicketEntity;
import br.com.LeoChiarelli.codechellaDDD.infrastructure.ticket.TypeEntity;

import java.util.ArrayList;
import java.util.List;

public class TicketEntityMapper {

    public static List<TicketEntity> toEntity(List<Ticket> tickets) {

        List<TicketEntity> ticketEntities = new ArrayList<>();

        for (Ticket ticket : tickets) {
            var ticketEntityList = TicketTypeEntityMapper.toEntity(List.of(ticket.getType()));
            for (TypeEntity ticketTypeEntity : ticketEntityList) {
               ticketEntities.add(new TicketEntity(ticket.getCode(), ticketTypeEntity));
            }
        }

        return ticketEntities;
    }

    public static List<Ticket> toDomain(List<TicketEntity> ticketsEntity) {

        List<Ticket> tickets = new ArrayList<>();

        for (TicketEntity ticketEntity : ticketsEntity) {
            var ticketList = TicketTypeEntityMapper.toDomain(List.of(ticketEntity.getType()));
            for (Type ticketType : ticketList) {
                tickets.add(Ticket.builder()
                        .withCode(ticketEntity.getCode())
                        .withType(ticketType)
                        .build());
            }
        }

        return tickets;
    }
}

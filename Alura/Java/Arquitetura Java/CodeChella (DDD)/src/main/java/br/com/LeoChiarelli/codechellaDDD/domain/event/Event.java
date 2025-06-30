package br.com.LeoChiarelli.codechellaDDD.domain.event;

import br.com.LeoChiarelli.codechellaDDD.domain.ticket.Type;
import br.com.LeoChiarelli.codechellaDDD.application.ValidationException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Event {

    private UUID uuid; /// UUID - Universally Unique Identifier
    private Category category;
    private String description;
    private Address address;
    private LocalDateTime date;
    private List<Type> ticketType = new ArrayList<>();

    public Event() {}

    public Event(Category category, String description, Address address, LocalDateTime date) {
        this.uuid = generateUUID();
        this.category = category;
        this.description = description;
        this.address = address;
        this.date = date;
    }

    private UUID generateUUID() {
        return UUID.randomUUID();
    }

    public void includesANewTypeOfEventTicket(Type ticketType) {
        this.ticketType.add(ticketType);
    }

    public void addMoreTicketNumberByType(Integer number, Type ticketType) {
        if (this.ticketType.contains(ticketType)){ throw new ValidationException("Ticket type unavailable to this event."); }
        ticketType.setTotalAvailable(ticketType.getTotalAvailable() + number);
    }

    public Category getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public Address getAddress() {
        return address;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public List<Type> getTicketType() {
        return ticketType;
    }
}

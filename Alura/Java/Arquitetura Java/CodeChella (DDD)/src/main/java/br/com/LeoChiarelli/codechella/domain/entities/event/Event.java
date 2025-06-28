package br.com.LeoChiarelli.codechella.domain.entities.event;

import br.com.LeoChiarelli.codechella.domain.valueObject.Address;
import br.com.LeoChiarelli.codechella.domain.valueObject.Category;
import br.com.LeoChiarelli.codechella.domain.entities.ticket.Type;
import br.com.LeoChiarelli.codechella.domain.entities.exception.ValidationException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Event {

    private Category category;
    private String description;
    private Address address;
    private LocalDateTime date;
    private List<Type> ticketType = new ArrayList<>();

    public Event() {}

    public Event(Category category, String description, Address address, LocalDateTime date, List<Type> ticketType) {
        this.category = category;
        this.description = description;
        this.address = address;
        this.date = date;
        this.ticketType = ticketType;
    }

    public void includesANewTypeOfEventTicket(Type ticketType) {
        this.ticketType.add(ticketType);
    }

    public void addMoreTicketNumberByType(Integer number, Type ticketType){
        if (this.ticketType.contains(ticketType)){ throw new ValidationException("Tipo de ingresso não disponível para este evento."); }
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

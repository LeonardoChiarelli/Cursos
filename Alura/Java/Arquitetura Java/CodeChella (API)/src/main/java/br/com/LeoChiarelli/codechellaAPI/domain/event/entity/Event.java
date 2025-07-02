package br.com.LeoChiarelli.codechellaAPI.domain.event.entity;

import br.com.LeoChiarelli.codechellaAPI.domain.event.valueObject.EventCategory;
import br.com.LeoChiarelli.codechellaAPI.domain.event.valueObject.RegistryEventDataDTO;
import br.com.LeoChiarelli.codechellaAPI.domain.event.valueObject.Address;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @Enumerated(EnumType.STRING)
    private EventCategory category;

    private LocalDateTime date;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Ticket> tickets = new ArrayList<>();

    public Event() {}

    public Event(RegistryEventDataDTO dados, List<Ticket> tickets) {
        this.name = dados.name();
        this.description = dados.description();
        this.category = dados.category();
        this.date = dados.date();
        this.address = dados.address();
        this.tickets.addAll(tickets);
        this.tickets.forEach(i -> i.setEvent(this));
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public EventCategory getCategory() {
        return category;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Address getEndereco() {
        return address;
    }

    public List<Ticket> getTickets() {
        return Collections.unmodifiableList(tickets);
    }

}

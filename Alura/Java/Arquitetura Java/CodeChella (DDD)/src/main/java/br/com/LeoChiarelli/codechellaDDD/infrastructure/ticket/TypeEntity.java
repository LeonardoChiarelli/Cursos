package br.com.LeoChiarelli.codechellaDDD.infrastructure.ticket;

import br.com.LeoChiarelli.codechellaDDD.domain.ticket.valueObject.Area;
import br.com.LeoChiarelli.codechellaDDD.domain.ticket.valueObject.Definition;
import br.com.LeoChiarelli.codechellaDDD.infrastructure.event.EventEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ticket_type")
public class TypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonIgnore
    private EventEntity event;

    @Enumerated(EnumType.STRING)
    private Area area;

    @Enumerated(EnumType.STRING)
    private Definition definition;

    private Double value;
    private int totalAvailable;

    @OneToMany(mappedBy = "type", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<TicketEntity> tickets = new ArrayList<>();

    private TypeEntity() {}

    public TypeEntity(Area area, Definition definition, Double value, int totalAvailable) {
        this.area = area;
        this.definition = definition;
        this.value = value;
        this.totalAvailable = totalAvailable;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EventEntity getEvent() {
        return event;
    }

    public void setEvent(EventEntity eventEntity) {
        this.event = eventEntity;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public Definition getDefinition() {
        return definition;
    }

    public void setDefinition(Definition definition) {
        this.definition = definition;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double valor) {
        this.value = valor;
    }

    public int getTotalAvailable() {
        return totalAvailable;
    }

    public void setTotalAvailable(int totalAvailable) {
        this.totalAvailable = totalAvailable;
    }

    public List<TicketEntity> getTickets() {
        return tickets;
    }

    public void setTickets(List<TicketEntity> ticketEntities) {
        ticketEntities.forEach(i -> i.setType(this));
        this.tickets = ticketEntities;
    }
}

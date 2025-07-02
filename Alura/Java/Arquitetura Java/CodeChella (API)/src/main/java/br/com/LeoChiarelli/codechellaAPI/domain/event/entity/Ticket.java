package br.com.LeoChiarelli.codechellaAPI.domain.event.entity;

import br.com.LeoChiarelli.codechellaAPI.domain.event.valueObject.TicketType;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Event event;

    private String description;

    private BigDecimal value;

    private String code;

    @ManyToOne
    private Purchase purchase;

    @Enumerated(EnumType.STRING)
    private TicketType type;

    @Version
    private Integer version;

    public Ticket() {}

    public Ticket(String description, BigDecimal value) {
        this.description = description;
        this.value = value;
        this.code = UUID.randomUUID().toString();
    }

    public void registryPurchase(Purchase purchase, TicketType type) {
        this.purchase = purchase;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getValue() {
        return value;
    }

    public String getCode() {
        return code;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public TicketType getType() {
        return type;
    }

}

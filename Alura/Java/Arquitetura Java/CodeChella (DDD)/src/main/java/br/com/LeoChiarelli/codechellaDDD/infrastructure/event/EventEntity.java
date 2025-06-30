package br.com.LeoChiarelli.codechellaDDD.infrastructure.event;

import br.com.LeoChiarelli.codechellaDDD.application.event.RegistryEventDTO;
import br.com.LeoChiarelli.codechellaDDD.domain.event.Category;
import br.com.LeoChiarelli.codechellaDDD.infrastructure.ticket.TypeEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "events")
public class EventEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Category category;

    private String description;

    @Embedded
    private AddressEntity address;

    private LocalDateTime date;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<TypeEntity> ticketsType = new ArrayList<>();

    public EventEntity() {}

    public EventEntity(RegistryEventDTO dto) {
        this.category = dto.category();
        this.description = dto.description();
        this.address = new AddressEntity(dto.address());
        this.date = dto.date();

        List<TypeEntity> type = dto.ticketType().stream()
                .map(i -> new TypeEntity(i.area(), i.definition(), i.value(), i.totalAvailable()))
                .collect(Collectors.toList());

        this.setTicketType(type);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public AddressEntity getEndereco() {
        return address;
    }

    public void setAddress(AddressEntity addressEntity) {
        this.address = addressEntity;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public List<TypeEntity> getTicketType() {
        return ticketsType;
    }

    public void setTicketType(List<TypeEntity> ticketTypeEntity) {
        ticketTypeEntity.forEach(i -> i.setEvent(this));
        this.ticketsType = ticketTypeEntity;
    }
}

package br.com.LeoChiarelli.codechellaDDD.domain.event;

import br.com.LeoChiarelli.codechellaDDD.application.ValidationException;
import br.com.LeoChiarelli.codechellaDDD.domain.event.valueObject.Address;
import br.com.LeoChiarelli.codechellaDDD.domain.event.valueObject.Category;
import br.com.LeoChiarelli.codechellaDDD.domain.ticket.Type;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class Event { /// Aggregated Root

private final UUID uuid; /// UUID - Universally Unique Identifier
private final Category category;
    private final String description;
    private final Address address;
    private final LocalDateTime date;
    private final List<Type> ticketTypes;

    private Event(UUID uuid, Category category, String description, Address address, LocalDateTime date) {
        if (category == null || description == null || description.isEmpty() || address == null || date == null) {
            throw new ValidationException("All core event details must be provided.");
        }
        this.uuid = uuid;
        this.category = category;
        this.description = description;
        this.address = address;
        this.date = date;
        this.ticketTypes = new ArrayList<>();
    }

    public static EventBuilder builder() {
        return new EventBuilder();
    }

    public void includesANewTypeOfEventTicket(Type ticketType) {
        if (ticketType == null) { throw new ValidationException("Ticket type cannot be null."); }
        if (this.ticketTypes.contains(ticketType)) { throw new ValidationException("This ticket type already exists for this event."); }

        this.ticketTypes.add(ticketType);
    }

    public void addMoreTicketNumberByType(Integer number, Type ticketType) {
        if (number <= 0) { throw new ValidationException("Number of tickets to add must be positive."); }

        Type existingTicketType = this.ticketTypes.stream()
                .filter(t -> t.equals(ticketType))
                .findFirst()
                .orElse(null);

        if (existingTicketType == null) {
            throw new ValidationException("Ticket type unavailable for this event.");
        }
        existingTicketType.setTotalAvailable(existingTicketType.getTotalAvailable() + number);
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

    public List<Type> getTicketTypes() {
        return Collections.unmodifiableList(ticketTypes);
    }

    @Override
    public String toString() {
        return "Event{" +
                "uuid=" + uuid +
                ", category=" + category +
                ", description='" + description + '\'' +
                ", address=" + address +
                ", date=" + date +
                ", ticketType=" + ticketTypes +
                '}';
    }

    public static class EventBuilder { /// Builder

        private Category category;
        private String description;
        private Address address;
        private LocalDateTime date;

        public EventBuilder() {}

        public EventBuilder withCategory(Category category) {
            this.category = category;
            return this;
        }

        public EventBuilder withDescription(String description) {
            this.description = description;
            return this;
        }

        public EventBuilder withAddress(String postalCode, Integer number, String complement) {
            this.address = Address.builder()
                    .withPostalCode(postalCode)
                    .withNumber(number)
                    .withComplement(complement)
                    .build();
            return this;
        }

        public EventBuilder withDate(LocalDateTime date) {
            this.date = date;
            return this;
        }

        public Event build() {
            if (category == null) {
                throw new ValidationException("Event category must be provided.");
            }
            if (description == null || description.trim().isEmpty()) {
                throw new ValidationException("Event description must be provided.");
            }
            if (address == null) {
                throw new ValidationException("Event address must be provided.");
            }
            if (date == null) {
                throw new ValidationException("Event date must be provided.");
            }

            return new Event(UUID.randomUUID(), this.category, this.description, this.address, this.date);
        }
    }
}

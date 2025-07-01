package br.com.LeoChiarelli.codechellaDDD.domain.sale;

import br.com.LeoChiarelli.codechellaDDD.application.ValidationException;
import br.com.LeoChiarelli.codechellaDDD.domain.ticket.Ticket;
import br.com.LeoChiarelli.codechellaDDD.domain.user.User;

import java.util.List;

public class Sale {

    private final User user;
    private final List<Ticket> tickets;

    private Sale(User user, List<Ticket> tickets) {
        if (user == null || tickets.isEmpty()) { throw new ValidationException("All core sale must be provided."); }
        this.user = user;
        this.tickets = tickets;
    }

    public static SaleBuilder builder() {
        return new SaleBuilder();
    }

    public User getUser() {
        return user;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public static class SaleBuilder {
        private User user;
        private List<Ticket> tickets;

        public SaleBuilder() {}

        public SaleBuilder withUser(User user) {
            this.user = user;
            return this;
        }

        public SaleBuilder withTickets(List<Ticket> tickets) {
            this.tickets = tickets;
            return this;
        }

        public Sale build() {
            if (user == null) { throw new ValidationException("Sale user must not be null."); }
            if (tickets.isEmpty()) { throw new ValidationException("Sale ticket list must not be null."); }

            return new Sale(user, tickets);
        }
    }
}

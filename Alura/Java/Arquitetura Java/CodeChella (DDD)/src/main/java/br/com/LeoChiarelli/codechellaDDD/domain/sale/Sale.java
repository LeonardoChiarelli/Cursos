package br.com.LeoChiarelli.codechellaDDD.domain.sale;

import br.com.LeoChiarelli.codechellaDDD.domain.ticket.Ticket;
import br.com.LeoChiarelli.codechellaDDD.domain.user.User;

import java.util.ArrayList;
import java.util.List;

public class Sale {

    private User user;
    private List<Ticket> tickets = new ArrayList<>();

    public Sale() {}

    public Sale(User user, List<Ticket> tickets) {
        this.user = user;
        this.tickets = tickets;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}

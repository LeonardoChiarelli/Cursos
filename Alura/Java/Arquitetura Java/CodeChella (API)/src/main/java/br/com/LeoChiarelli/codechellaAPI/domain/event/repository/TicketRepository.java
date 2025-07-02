package br.com.LeoChiarelli.codechellaAPI.domain.event.repository;

import br.com.LeoChiarelli.codechellaAPI.domain.event.entity.Purchase;
import br.com.LeoChiarelli.codechellaAPI.domain.event.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    @Query("SELECT COUNT(i) >= :quantity FROM Ticket i WHERE i.event.id = :eventID AND i.description = :description")
    Boolean areTicketsAvailable(Long eventID, String description, Integer quantity);

    @Query("SELECT i FROM Ticket i WHERE i.event.id = :eventID AND i.description = :description AND i.purchase IS NULL ORDER BY i.id LIMIT :quantity")
    List<Ticket> findAvailableTickets(Long eventID, String description, Integer quantity);

    List<Ticket> findAllByPurchase(Purchase purchase);

}

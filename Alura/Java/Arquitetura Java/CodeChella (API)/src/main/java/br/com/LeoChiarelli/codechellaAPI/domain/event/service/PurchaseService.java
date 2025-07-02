package br.com.LeoChiarelli.codechellaAPI.domain.event.service;

import br.com.LeoChiarelli.codechellaAPI.domain.BusinessRuleException;
import br.com.LeoChiarelli.codechellaAPI.domain.authentication.entity.User;
import br.com.LeoChiarelli.codechellaAPI.domain.event.entity.Purchase;
import br.com.LeoChiarelli.codechellaAPI.domain.event.entity.Ticket;
import br.com.LeoChiarelli.codechellaAPI.domain.event.repository.PurchaseRepository;
import br.com.LeoChiarelli.codechellaAPI.domain.event.repository.TicketRepository;
import br.com.LeoChiarelli.codechellaAPI.domain.event.valueObject.PurchaseDataDTO;
import br.com.LeoChiarelli.codechellaAPI.domain.event.valueObject.PurchaseTicketDataDTO;
import br.com.LeoChiarelli.codechellaAPI.domain.event.valueObject.RegistryPurchaseDataDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PurchaseService {

    private final PurchaseRepository purchaseRepository;
    private final TicketRepository ticketRepository;

    public PurchaseService(PurchaseRepository purchaseRepository, TicketRepository ticketRepository) {
        this.purchaseRepository = purchaseRepository;
        this.ticketRepository = ticketRepository;
    }

    public List<PurchaseDataDTO> listMyPurchases(User user) {
        var purchaseData = new ArrayList<PurchaseDataDTO>();
        var purchases = purchaseRepository.findAllByUser(user);
        purchases.forEach(purchase -> {
            var tickets = ticketRepository.findAllByPurchase(purchase);
            purchaseData.add(new PurchaseDataDTO(purchase, tickets));
        });
        return purchaseData;
    }

    public PurchaseDataDTO detail(Long id) {
        var purchase = purchaseRepository.findById(id).orElseThrow(() -> new BusinessRuleException("Purchase not found."));
        var tickets = ticketRepository.findAllByPurchase(purchase);
        return new PurchaseDataDTO(purchase, tickets);
    }

    public PurchaseDataDTO makePurchase(RegistryPurchaseDataDTO dto, User user) {
        validateTicketAvailabilityForTheEvent(dto);
        var purchase = savePurchase(dto, user);
        var tickets = buyTicket(dto, purchase);
        return new PurchaseDataDTO(purchase, tickets);
    }

    private void validateTicketAvailabilityForTheEvent(RegistryPurchaseDataDTO dto) {
        dto.tickets().forEach(ticket -> {
            var available = ticketRepository.areTicketsAvailable(dto.eventId(), ticket.description(), ticket.quantity());
            if (!available) {
                throw new BusinessRuleException("Quantity unavailable for ticket type: " + ticket.description());
            }
        });
    }

    private Purchase savePurchase(RegistryPurchaseDataDTO dto, User user) {
        var purchase = new Purchase(user, dto.paymentMethod());
        this.purchaseRepository.save(purchase);
        return purchase;
    }

    private List<Ticket> buyTicket(RegistryPurchaseDataDTO dto, Purchase purchase) {
        var boughtTickets = new ArrayList<Ticket>();
        var quantityByTypeAndDescription = dto.tickets()
                .stream()
                .collect(Collectors.groupingBy(
                        PurchaseTicketDataDTO::description,
                        Collectors.groupingBy(
                                PurchaseTicketDataDTO::type,
                                Collectors.summingInt(PurchaseTicketDataDTO::quantity))));

        quantityByTypeAndDescription.forEach((description, quantityByType) -> {
            quantityByType.forEach((type, quantity) -> {
                var availableTickets = ticketRepository.findAvailableTickets(dto.eventId(), description, quantity);
                if (availableTickets.size() != quantity) {
                    throw new BusinessRuleException("Quantity unavailable for ticket type: " +description);
                }
                availableTickets.forEach(i -> {
                    i.registryPurchase(purchase, type);
                    boughtTickets.add(i);
                });
            });
        });

        return boughtTickets;
    }

}

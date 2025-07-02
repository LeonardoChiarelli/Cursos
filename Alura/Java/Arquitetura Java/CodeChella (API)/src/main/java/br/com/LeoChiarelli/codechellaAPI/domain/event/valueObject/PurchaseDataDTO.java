package br.com.LeoChiarelli.codechellaAPI.domain.event.valueObject;

import br.com.LeoChiarelli.codechellaAPI.domain.event.entity.Purchase;
import br.com.LeoChiarelli.codechellaAPI.domain.event.entity.Ticket;

import java.time.LocalDateTime;
import java.util.List;

public record PurchaseDataDTO(Long id, LocalDateTime date, PaymentMethod paymentMethod, List<TicketPurchaseDataDTO> tickets) {

    public PurchaseDataDTO(Purchase purchase, List<Ticket> tickets) {
        this(purchase.getId(), purchase.getDate(), purchase.getFormaDePagamento(), tickets.stream().map(TicketPurchaseDataDTO::new).toList());
    }

}

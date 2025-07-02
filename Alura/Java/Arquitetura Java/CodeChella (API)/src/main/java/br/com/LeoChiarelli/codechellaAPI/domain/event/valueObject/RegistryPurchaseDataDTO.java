package br.com.LeoChiarelli.codechellaAPI.domain.event.valueObject;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public record RegistryPurchaseDataDTO(
        @NotNull(message = "Event ID is require!")
        Long eventId,

        @NotNull(message = "Payment method is require!")
        PaymentMethod paymentMethod,

        @NotNull(message = "At least 1 ticket must be purchased!")
        @Size(message = "At least 1 ticket must be purchased!")
        List<PurchaseTicketDataDTO> tickets) {
}

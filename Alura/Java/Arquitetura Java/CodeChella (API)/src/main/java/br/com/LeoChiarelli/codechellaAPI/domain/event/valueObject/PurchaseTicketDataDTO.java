package br.com.LeoChiarelli.codechellaAPI.domain.event.valueObject;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PurchaseTicketDataDTO(
        @NotBlank(message = "Ticket description is require!")
        String description,

        @NotNull(message = "Ticket quantity is require!")
        @Min(value = 1, message = "Minimum ticket quantity must be 1!")
        Integer quantity,

        @NotNull(message = "Ticket type is require!")
        TicketType type) {
}

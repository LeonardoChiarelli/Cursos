package br.com.LeoChiarelli.codechellaAPI.domain.event.valueObject;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record RegistryTicketDataDTO(
        @NotBlank(message = "Ticket description is require!")
        String description,

        @NotNull(message = "Ticket value is require!")
        BigDecimal value,

        @NotNull(message = "Ticket quantity is require!")
        @Min(value = 1, message = "Minimum ticket quantity must be 1!")
        Integer quantity
) {}

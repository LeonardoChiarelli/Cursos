package br.com.LeoChiarelli.codechellaAPI.domain.event.valueObject;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;

public record RegistryEventDataDTO(
        @NotBlank(message = "Event name is require!")
        String name,

        @NotBlank(message = "Event description is require!")
        String description,

        @NotNull(message = "Event category is require!")
        EventCategory category,

        @NotNull(message = "Event date is require!")
        @Future(message = "Event date must be a future date!")
        LocalDateTime date,

        @NotNull(message = "Event address is require!")
        @Valid
        Address address,

        @NotNull(message = "At least one ticket type must be entered!")
        @Valid
        List<RegistryTicketDataDTO> tickets
) {}

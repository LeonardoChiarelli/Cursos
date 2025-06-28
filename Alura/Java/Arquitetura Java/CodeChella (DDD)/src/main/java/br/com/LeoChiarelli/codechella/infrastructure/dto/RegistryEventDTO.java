package br.com.LeoChiarelli.codechella.infrastructure.dto;

import br.com.LeoChiarelli.codechella.domain.valueObject.Category;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;

public record RegistryEventDTO(

        @NotNull(message = "A categoria do evento é obrigatória!")
        Category category,

        @NotBlank(message = "A descrição do evento é obrigatória!")
        String description,

        @NotNull(message = "O endereço do evento é obrigatório!")
        @Valid
        AddressDTO address,

        @NotNull(message = "Data do evento é obrigatória!")
        @Future(message = "Data do evento deve ser uma data futura!")
        LocalDateTime date,

        @NotNull(message = "Pelo menos um tipo de ingresso deve ser informado!")
        @Valid
        List<RegistryTicketTypeDTO> ticketType

) {
}

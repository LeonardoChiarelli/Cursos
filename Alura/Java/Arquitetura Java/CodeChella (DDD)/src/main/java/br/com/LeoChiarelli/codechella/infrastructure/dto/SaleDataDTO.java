package br.com.LeoChiarelli.codechella.infrastructure.dto;

import java.util.List;

public record SaleDataDTO(
        Long id,
        UserDataDTO usuario,
        List<TicketTypeDataDTO> ingressos
) {
}

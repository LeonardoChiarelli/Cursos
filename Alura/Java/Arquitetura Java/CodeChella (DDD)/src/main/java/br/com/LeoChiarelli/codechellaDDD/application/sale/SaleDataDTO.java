package br.com.LeoChiarelli.codechellaDDD.application.sale;

import br.com.LeoChiarelli.codechellaDDD.application.ticket.TicketTypeDataDTO;
import br.com.LeoChiarelli.codechellaDDD.application.user.UserDataDTO;

import java.util.List;

public record SaleDataDTO(
        Long id,
        UserDataDTO usuario,
        List<TicketTypeDataDTO> ingressos
) {
}

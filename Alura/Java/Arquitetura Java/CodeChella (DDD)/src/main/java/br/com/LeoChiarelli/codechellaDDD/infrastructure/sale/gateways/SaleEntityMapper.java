package br.com.LeoChiarelli.codechellaDDD.infrastructure.sale.gateways;

import br.com.LeoChiarelli.codechellaDDD.domain.sale.Sale;
import br.com.LeoChiarelli.codechellaDDD.infrastructure.sale.SaleEntity;
import br.com.LeoChiarelli.codechellaDDD.infrastructure.ticket.gateways.TicketEntityMapper;
import br.com.LeoChiarelli.codechellaDDD.infrastructure.user.gateways.UserEntityMapper;

public class SaleEntityMapper {

    public SaleEntity toEntity(Sale saleDomain){
        return new SaleEntity(UserEntityMapper.toEntity(saleDomain.getUser()), TicketEntityMapper.toEntity(saleDomain.getTickets()));
    }

    public Sale toDomain(SaleEntity saleEntity){
        return Sale.builder()
                .withUser(UserEntityMapper.toDomain(saleEntity.getUser()))
                .withTickets(TicketEntityMapper.toDomain(saleEntity.getTickets()))
                .build();
    }
}

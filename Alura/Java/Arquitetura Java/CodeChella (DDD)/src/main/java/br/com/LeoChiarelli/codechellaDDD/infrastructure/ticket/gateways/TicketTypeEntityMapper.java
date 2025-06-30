package br.com.LeoChiarelli.codechellaDDD.infrastructure.ticket.gateways;

import br.com.LeoChiarelli.codechellaDDD.domain.ticket.Type;
import br.com.LeoChiarelli.codechellaDDD.infrastructure.ticket.TypeEntity;

import java.util.List;

public class TicketTypeEntityMapper {

    public static List<TypeEntity> toEntity(List<Type> ticketTypeDomain) {
        return ticketTypeDomain.stream()
                .map(type -> { return new TypeEntity(type.getArea(), type.getDefinition(), type.getValue(), type.getTotalAvailable()); })
                .toList();
    }

    public static List<Type> toDomain(List<TypeEntity> ticketTypeEntity) {
        return ticketTypeEntity.stream()
                .map(typeEntity -> { return new Type(typeEntity.getArea(), typeEntity.getDefinition(), typeEntity.getValue(), typeEntity.getTotalAvailable()); })
                .toList();
    }
}

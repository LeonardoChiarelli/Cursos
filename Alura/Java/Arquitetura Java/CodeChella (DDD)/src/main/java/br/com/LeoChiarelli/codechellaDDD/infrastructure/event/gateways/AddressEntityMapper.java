package br.com.LeoChiarelli.codechellaDDD.infrastructure.event.gateways;

import br.com.LeoChiarelli.codechellaDDD.domain.event.valueObject.Address;
import br.com.LeoChiarelli.codechellaDDD.infrastructure.event.AddressEntity;

public class AddressEntityMapper {
    public static AddressEntity toEntity(Address addressDomain) {
        return new AddressEntity(addressDomain.getPostalCode(), addressDomain.getNumber(), addressDomain.getComplement());
    }

    public static Address toDomain(AddressEntity addressEntity) {
        return Address.builder()
                .withPostalCode(addressEntity.getPostalCode())
                .withNumber(addressEntity.getNumber())
                .withComplement(addressEntity.getComplement())
                .build();

    }
}

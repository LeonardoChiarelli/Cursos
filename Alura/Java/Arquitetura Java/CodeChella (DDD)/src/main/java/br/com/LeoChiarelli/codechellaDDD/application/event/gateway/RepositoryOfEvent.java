package br.com.LeoChiarelli.codechellaDDD.application.event.gateway;

import br.com.LeoChiarelli.codechellaDDD.domain.event.Event;
import br.com.LeoChiarelli.codechellaDDD.domain.event.valueObject.Address;

public interface RepositoryOfEvent {

    Event findEventByCity(Address postalCode);
}

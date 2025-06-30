package br.com.LeoChiarelli.codechellaDDD.infrastructure.event;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<EventEntity, Long> {

}

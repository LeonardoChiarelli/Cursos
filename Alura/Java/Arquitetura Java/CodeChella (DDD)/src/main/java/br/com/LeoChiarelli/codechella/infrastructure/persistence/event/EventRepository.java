package br.com.LeoChiarelli.codechella.infrastructure.persistence.event;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<EventEntity, Long> {

}

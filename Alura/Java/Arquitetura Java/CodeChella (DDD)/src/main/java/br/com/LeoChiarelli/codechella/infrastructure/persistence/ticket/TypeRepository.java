package br.com.LeoChiarelli.codechella.infrastructure.persistence.ticket;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepository extends JpaRepository<TypeEntity, Long> {
}

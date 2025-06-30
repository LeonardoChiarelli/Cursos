package br.com.LeoChiarelli.codechellaDDD.infrastructure.ticket;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepository extends JpaRepository<TypeEntity, Long> {
}

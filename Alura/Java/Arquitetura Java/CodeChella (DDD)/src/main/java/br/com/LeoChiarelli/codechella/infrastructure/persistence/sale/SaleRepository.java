package br.com.LeoChiarelli.codechella.infrastructure.persistence.sale;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<SaleEntity, Long> {
}

package br.com.LeoChiarelli.codechellaDDD.infrastructure.sale;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<SaleEntity, Long> {
}

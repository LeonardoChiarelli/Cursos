package br.com.LeoChiarelli.adopet.domain.repository;

import br.com.LeoChiarelli.adopet.domain.models.Abrigo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAbrigoRepository extends JpaRepository<Abrigo, Long> {

    Page<Abrigo> findAll(Pageable pageable);
}

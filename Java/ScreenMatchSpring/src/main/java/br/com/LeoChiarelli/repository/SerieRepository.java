package br.com.LeoChiarelli.repository;

import br.com.LeoChiarelli.models.Serie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SerieRepository extends JpaRepository<Serie, Long> {
}

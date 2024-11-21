package br.com.LeoChiarelli.repository;

import br.com.LeoChiarelli.models.Category;
import br.com.LeoChiarelli.models.Episode;
import br.com.LeoChiarelli.models.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SerieRepository extends JpaRepository<Serie, Long> {
    Optional<Serie> findByTitleContainingIgnoreCase(String serieName);
    List<Serie> findByActorsContainingIgnoreCase(String actorName);
    List<Serie> findByRatingGreaterThanEqualOrderByRatingDesc(Double serieRating);
    List<Serie> findByGenre(Category category);
    @Query("select s from Serie s where s.totalSeasons <= :totalSeasons and s.rating >= :serieRating") // trocando para atributos da classe e parâmetros // QUERY JPQL
    List<Serie> seriesBySeasonsAndRating(Integer totalSeasons, Double serieRating);
    @Query("SELECT e FROM Serie s JOIN s.episodes e WHERE e.title ILIKE %:splitOfEpisode%")
    List<Episode> episodiesBySplit(String splitOfEpisode);
}

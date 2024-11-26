package br.com.LeoChiarelli.repository;

import br.com.LeoChiarelli.models.Category;
import br.com.LeoChiarelli.models.Episode;
import br.com.LeoChiarelli.models.Serie;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SerieRepository extends JpaRepository<Serie, Long> {
    Optional<Serie> findByTitleContainingIgnoreCase(String serieName);
    List<Serie> findByActorsContainingIgnoreCase(String actorName);
    List<Serie> findByRatingGreaterThanEqualOrderByRatingDesc(Double serieRating);
    List<Serie> findByGenre(Category category);
    Optional<Serie> findById(Long id);

    @Query("SELECT s FROM Serie s WHERE s.totalSeasons <= :totalSeasons AND s.rating >= :serieRating") // trocando para atributos da classe e parâmetros // QUERY JPQL
    List<Serie> seriesBySeasonsAndRating(Integer totalSeasons, Double serieRating);

    @Query("SELECT e FROM Serie s JOIN s.episodes e WHERE e.title ILIKE %:splitOfEpisode%")
    List<Episode> episodesBySplit(String splitOfEpisode);

    @Query("SELECT s FROM Serie s WHERE s.rating > 0 ORDER BY rating DESC LIMIT 5")
    List<Serie> top5Series();

    @Query("SELECT e FROM Serie s JOIN s.episodes e WHERE s = :serie ORDER BY e.rating DESC LIMIT 5")
    List<Episode> topEpisodesBySerie(Serie serie);

    @Query("SELECT e FROM Serie s JOIN s.episodes e WHERE s = :serie AND YEAR(e.dateOfRelease) >= :yearOfRelease")
    List<Episode> episodesByReleaseDate(Serie serie, int yearOfRelease);

    @Query("SELECT s FROM Serie s JOIN s.episodes e GROUP BY s ORDER BY MAX(e.dateOfRelease) DESC LIMIT 5")
    List<Serie> findTheLatestEpisodes();
}

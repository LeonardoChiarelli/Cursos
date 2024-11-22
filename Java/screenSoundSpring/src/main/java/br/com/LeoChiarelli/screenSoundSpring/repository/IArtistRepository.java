package br.com.LeoChiarelli.screenSoundSpring.repository;

import br.com.LeoChiarelli.screenSoundSpring.models.Artist;
import br.com.LeoChiarelli.screenSoundSpring.models.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IArtistRepository extends JpaRepository<Artist, Long> {
    Optional<Artist> findByNameContainingIgnoreCase(String artistName);

    @Query("SELECT a FROM Music m JOIN a.songs m WHERE a = :artistName ")
    List<Music> listOfSongs(Artist artistName);
}

package br.com.LeoChiarelli.screenSoundSpring.repository;

import br.com.LeoChiarelli.screenSoundSpring.models.Artist;
import br.com.LeoChiarelli.screenSoundSpring.models.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IArtistRepository extends JpaRepository<Artist, Long> {
    Optional<Artist> findByNameContainingIgnoreCase(String artistName);

    @Query("SELECT m FROM Artist a JOIN a.songs m WHERE a = :artistName")
    List<Music> listSongs(Artist artistName);

    @Query("SELECT m FROM Artist a JOIN a.songs m WHERE m.title ILIKE %:musicName%")
    Optional<Music> searchMusic(String musicName);

    @Query("SELECT a FROM Music m JOIN m.artist a WHERE m.title = :music")
    Artist findArtist(String music);
}

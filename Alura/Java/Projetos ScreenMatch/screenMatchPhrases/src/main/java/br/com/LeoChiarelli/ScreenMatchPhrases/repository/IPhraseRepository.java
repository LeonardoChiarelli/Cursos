package br.com.LeoChiarelli.ScreenMatchPhrases.repository;

import br.com.LeoChiarelli.ScreenMatchPhrases.models.Phrase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IPhraseRepository extends JpaRepository<Phrase, Long> {

    @Query("SELECT p FROM Phrase p ORDER BY FUNCTION('RANDOM') LIMIT 1")
    Phrase searchRandomPhrase();
}

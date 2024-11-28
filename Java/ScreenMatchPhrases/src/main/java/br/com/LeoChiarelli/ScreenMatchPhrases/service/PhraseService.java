package br.com.LeoChiarelli.ScreenMatchPhrases.service;

import br.com.LeoChiarelli.ScreenMatchPhrases.models.Phrase;
import br.com.LeoChiarelli.ScreenMatchPhrases.dto.PhraseDTO;
import br.com.LeoChiarelli.ScreenMatchPhrases.repository.IPhraseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhraseService {
    @Autowired
    private IPhraseRepository repository;

    public PhraseDTO getRandomPhrases(){
        Phrase phrase = repository.searchRandomPhrase();
        return new PhraseDTO(phrase.getTitle(), phrase.getPhrase(), phrase.getCharacter(), phrase.getPoster());
    }
}

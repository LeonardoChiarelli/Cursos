package br.com.LeoChiarelli.ScreenMatchPhrases.controller;

import br.com.LeoChiarelli.ScreenMatchPhrases.dto.PhraseDTO;
import br.com.LeoChiarelli.ScreenMatchPhrases.service.PhraseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PhraseController {

    @Autowired
    private PhraseService service;

    @GetMapping("/series/frases")
    public PhraseDTO searchRandomPhrase(){
        return service.getRandomPhrases();
    }
}

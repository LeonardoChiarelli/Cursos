package br.com.LeoChiarelli.controller;

import br.com.LeoChiarelli.dto.EpisodeDTO;
import br.com.LeoChiarelli.dto.SerieDTO;
import br.com.LeoChiarelli.models.Episode;
import br.com.LeoChiarelli.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/series")
public class SerieController {

    @Autowired
    private SerieService service;

    @GetMapping // Deve ser usada acima do metodo que deve ser chamado assim que a requisição acontecer
    public List<SerieDTO> getSeries(){
        return service.getAllSeries();
    }

    @GetMapping("/top5")
    public List<SerieDTO> getTop5(){
        return service.getTop5Series();
    }

    @GetMapping("/lancamentos")
    public List<SerieDTO> getReleases(){
        return service.getRelease();
    }

    @GetMapping("/{id}")
    public SerieDTO getById(@PathVariable Long id){
        return service.getById(id);
    }

    @GetMapping("/{id}/temporadas/todas")
    public List<EpisodeDTO> getAllSeasons(@PathVariable Long id){
        return service.getAllSeasons(id);
    }

    @GetMapping("/{id}/temporadas/{numTemp}")
    public List<EpisodeDTO> getSeasonsByNumber(@PathVariable Long id, @PathVariable Long numTemp){
        return service.getSeasonByNumber(id, numTemp);
    }

    @GetMapping("/categoria/{genero}")
    public List<SerieDTO> getSerieByGenre(@PathVariable String genero){
        return service.getSerieByGenre(genero);
    }

}

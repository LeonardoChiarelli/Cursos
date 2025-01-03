package br.com.LeoChiarelli.service;

import br.com.LeoChiarelli.dto.EpisodeDTO;
import br.com.LeoChiarelli.dto.SerieDTO;
import br.com.LeoChiarelli.models.Category;
import br.com.LeoChiarelli.models.Serie;
import br.com.LeoChiarelli.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SerieService {
    @Autowired
    private SerieRepository repository;
    private List<SerieDTO> convertData(List<Serie> series){
        return series.stream()
                .map(s -> new SerieDTO(s.getId(), s.getTitle(), s.getRating(), s.getTotalSeasons(), s.getGenre(), s.getYear(), s.getActors(), s.getWriter(), s.getPoster(), s.getSynopsis()))
                .collect(Collectors.toList());
    }

    public List<SerieDTO> getAllSeries() {
        return convertData(repository.findAll());
    }

    public List<SerieDTO> getTop5Series() {
        return convertData(repository.top5Series());
    }

    public List<SerieDTO> getRelease(){
        return convertData(repository.findTheLatestEpisodes());
    }

    public SerieDTO getById(Long id) {
        Optional<Serie> serie = repository.findById(id);
        if (serie.isPresent()) {
            Serie s = serie.get();
            return new SerieDTO(s.getId(), s.getTitle(), s.getRating(), s.getTotalSeasons(), s.getGenre(), s.getYear(), s.getActors(), s.getWriter(), s.getPoster(), s.getSynopsis());
        } else {
            return null;
        }
    }

    public List<EpisodeDTO> getAllSeasons(Long id) {
        Optional<Serie> serie = repository.findById(id);
        if (serie.isPresent()) {
            Serie s = serie.get();
            return s.getEpisodes().stream()
                    .map(e-> new EpisodeDTO(e.getSeason(), e.getTitle(), e.getEpisode()))
                    .collect(Collectors.toList());
        } else {
            return null;
        }
    }

    public List<EpisodeDTO> getSeasonByNumber(Long id, Long numTemp) {
        return repository.getEpisodesBySeason(id, numTemp).stream()
                .map(e -> new EpisodeDTO(e.getSeason(), e.getTitle(), e.getEpisode()))
                .collect(Collectors.toList());
    }

    public List<SerieDTO> getSerieByGenre(String genero) {
        Category category = Category.withouAceent(genero);
        return repository.findByGenre(category).stream()
                .map(s -> new SerieDTO(s.getId(), s.getTitle(), s.getRating(), s.getTotalSeasons(), s.getGenre(), s.getYear(), s.getActors(), s.getWriter(), s.getPoster(), s.getSynopsis()))
                .collect(Collectors.toList());
    }
}

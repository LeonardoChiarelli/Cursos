package br.com.LeoChiarelli.service;

import br.com.LeoChiarelli.dto.SerieDTO;
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
}

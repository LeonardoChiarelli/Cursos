package br.com.LeoChiarelli.models;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Episode {
    private Integer temporada;
    private String title;
    private String episode;
    private Double rating;
    private LocalDate dataLancamento;

    public Episode(Integer temporada, EpisodesData dadosEpisodio) {
        this.temporada = temporada;
        this.title = dadosEpisodio.title();
        this.episode = dadosEpisodio.episode();

        try {
            this.rating = Double.valueOf(dadosEpisodio.rating());
        } catch (NumberFormatException e){
            this.rating = 0.0;
        }

        try {
            this.dataLancamento = LocalDate.parse(dadosEpisodio.dataLancamento());
        } catch (DateTimeParseException e){
            this.dataLancamento = null;
        }

    }


    public Integer getTemporada() {
        return temporada;
    }

    public void setTemporada(Integer temporada) {
        this.temporada = temporada;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEpisode() {
        return episode;
    }

    public void setEpisode(String episode) {
        this.episode = episode;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    @Override
    public String toString() {
        return "{Temporada " + this.temporada +
                "\nEpisódio: " + this.episode +
                "\nTítulo: '" + this.title + "'" +
                "\nAvaliação: " + this.rating +
                "\nData de Lançamento: " + this.dataLancamento + "}\n";
    }
}

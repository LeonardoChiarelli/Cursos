package br.com.LeoChiarelli.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

@Entity
@Table(name = "Episodios")
public class Episode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "temporada")
    private Integer temporada;

    @Column(name = "titulo")
    private String title;

    @Column(name = "episodio")
    private String episode;

    @Column(name = "avaliacao")
    private Double rating;

    @Column(name = "data_de_lancamento")
    private LocalDate dataLancamento;

    @ManyToOne
    private Serie serie;

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

    public Episode(){}

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

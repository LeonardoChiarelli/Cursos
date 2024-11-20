package br.com.LeoChiarelli.models;

import br.com.LeoChiarelli.service.ConsultMyMemory;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;

@Entity // Para indicar que vai ser uma tabela do banco de dados
@Table(name = "Series") // Para indicar o nome que queremos no banco de dados
public class Serie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="Título", nullable = false, unique = true)
    private String title;

    @Column(name="Avaliacao")
    private Double rating;

    @Column(name="TotalDeTemporadas", nullable = false)
    private Integer totalSeasons;

    @Column(name="Genero", nullable = false)
    @Enumerated(EnumType.STRING)
    private Category genre;

    @Column(name="Ano")
    private String year;

    @Column(name="Atores")
    private String actors;

    @Column(name="Escritor(a)")
    private String writer;

    @Column(name="Poster")
    private String poster;

    @Column(name="Sinopse")
    private String synopsis;

    @Transient
    private List<Episode> episodes = new ArrayList<>();

    public Serie(){}

    public Serie(SeriesData seriesData){
        this.title = seriesData.title();
        this.rating = OptionalDouble.of(Double.parseDouble(seriesData.rating())).orElse(0.0);
        this.totalSeasons = OptionalInt.of(Integer.parseInt(seriesData.totalSeasons())).orElse(0);
        this.genre = Category.fromString(seriesData.genre().split(",")[0].trim());
        this.year = seriesData.year();
        this.actors = seriesData.actors();
        this.writer = seriesData.writer();
        this.poster = seriesData.poster();
        this.synopsis = ConsultMyMemory.getTranslation(seriesData.synopsis()).trim();
    }



    // Getters

    public Long getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public Double getRating() {
        return rating;
    }
    public Integer getTotalSeasons() {
        return totalSeasons;
    }
    public Category getGenre() {
        return genre;
    }
    public String getYear() {
        return year;
    }
    public String getActors() {
        return actors;
    }
    public String getWriter() {
        return writer;
    }
    public String getPoster() {
        return poster;
    }
    public String getSynopsis() {
        return synopsis;
    }

    public List<Episode> getEpisodes() {
        return episodes;
    }

    // Setters

    public void setId(Long id) {
        this.id = id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setRating(Double rating) {
        this.rating = rating;
    }
    public void setTotalSeasons(Integer totalSeasons) {
        this.totalSeasons = totalSeasons;
    }
    public void setGenre(Category genre) {
        this.genre = genre;
    }
    public void setYear(String year) {
        this.year = year;
    }
    public void setActors(String actors) {
        this.actors = actors;
    }
    public void setWriter(String writer) {
        this.writer = writer;
    }
    public void setPoster(String poster) {
        this.poster = poster;
    }
    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }
    public void setEpisodes(List<Episode> episodes) {
        this.episodes = episodes;
    }

    @Override
    public String toString() {
        return "{Gênero: " + this.getGenre() +
                "\nTítulo: " + this.getTitle() +
                "\nAvaliação: " + this.getRating() + "/10" +
                "\nTotal de Temporadas: " + this.getTotalSeasons() +
                "\nAno: " + this.getYear() +
                "\nAtores: " + this.getActors() +
                "\nAutor(a): " + this.getWriter() +
                "\nSinopse: " + this.getSynopsis() + "}\n";
    }
}

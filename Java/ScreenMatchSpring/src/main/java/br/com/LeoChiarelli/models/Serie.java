package br.com.LeoChiarelli.models;

import br.com.LeoChiarelli.service.ConsultMyMemory;

import java.util.OptionalDouble;
import java.util.OptionalInt;

public class Serie {
    private String title;
    private Double rating;
    private Integer totalSeasons;
    private Category genre;
    private String year;
    private String actors;
    private String writer;
    private String poster;
    private String synopsis;

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

    @Override
    public String toString() {
        return "Gênero: " + this.getGenre() +
                "\nTítulo: " + this.getTitle() +
                "\nAvaliação: " + this.getRating() + "/10" +
                "\nTotal de Temporadas: " + this.getTotalSeasons() +
                "\nAno: " + this.getYear() +
                "\nAtores: " + this.getActors() +
                "\nAutor(a): " + this.getWriter() +
                "\nSinopse: " + this.getSynopsis();
    }
}

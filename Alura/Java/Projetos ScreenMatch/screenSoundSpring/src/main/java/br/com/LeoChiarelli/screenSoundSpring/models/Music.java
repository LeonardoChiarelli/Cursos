package br.com.LeoChiarelli.screenSoundSpring.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Musicas")
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo")
    private String title;

    @ManyToOne
    private Artist artist;

    public Music() {}

    public Music(String musicTitle) {
        this.title = musicTitle;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    @Override
    public String toString() {
        return "Título: " + this.title +
                "Artista: " + this.artist;
    }
}

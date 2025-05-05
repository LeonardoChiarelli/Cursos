package br.com.LeoChiarelli.screenSoundSpring.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Artistas")
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", unique = true)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "categoria_artista")
    private ArtistCategory category;

    @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Music> songs = new ArrayList<>();

    public Artist() {}

    public Artist(String artistName, ArtistCategory artistCategory) {
        this.name = artistName;
        this.category = artistCategory;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArtistCategory getCategory() {
        return category;
    }

    public void setCategory(ArtistCategory category) {
        this.category = category;
    }

    public List<Music> getSongs() {
        return songs;
    }

    public void setSongs(List<Music> songs) {
        this.songs = songs;
    }

    @Override
    public String toString() {
        return "Artista: " + this.name +
                "Categoria: " + this.category +
                "Lista de músicas: " + this.songs;
    }
}

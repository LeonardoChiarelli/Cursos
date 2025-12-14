package br.com.LeoChiarelli.screenSoundSpring.main;

import br.com.LeoChiarelli.screenSoundSpring.models.Artist;
import br.com.LeoChiarelli.screenSoundSpring.models.ArtistCategory;
import br.com.LeoChiarelli.screenSoundSpring.models.Music;
import br.com.LeoChiarelli.screenSoundSpring.repository.IArtistRepository;
import br.com.LeoChiarelli.screenSoundSpring.service.ChatgptQuery;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    Scanner scan = new Scanner(System.in);
    private final IArtistRepository repository;
    private Optional<Artist> optionalArtist;

    public Main(IArtistRepository repository) {
        this.repository = repository;
    }

    public void displayMenu() {
        var option = -1;
        while (option != 0) {
            var menu = """
                    1 - Cadastrar artistas
                    2 - Cadastrar música
                    3 - Listar músicas
                    4 - Buscar música por artistas
                    
                    0 - Sair
                    """;
            System.out.println(menu);
            option = scan.nextInt();
            scan.nextLine();

            switch (option){
                case 1:
                    registerArtists();
                    break;
                case 2:
                    registerMusic();
                    break;
                case 3:
                    listSongs();
                    break;
                case 4:
                    searchMusicByArtist();
                    break;
                case 5:
                    searchArtistData();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }

        }
    }
    private void registerArtists(){
        var userChoice = "S";
        while (userChoice.equalsIgnoreCase("S")) {
            System.out.println("Informe o nome do artista: ");
            var artistName = scan.nextLine();

            System.out.println("Informe a categoria desse artista (solo, dupla ou banda): ");
            var artistCategory = scan.nextLine();
            ArtistCategory category = ArtistCategory.fromPortuguse(artistCategory.toUpperCase());


            Artist artist = new Artist(artistName, category);
            repository.save(artist);
            System.out.println("Deseja cadastrar outro artista? (S / N): ");
            userChoice = scan.nextLine();
        }
    }
    private void registerMusic(){
        System.out.println("De qual artista é a música que você deseja cadastrar?");
        var artistName = scan.nextLine();

        Optional<Artist> optionalArtist = repository.findByNameContainingIgnoreCase(artistName);
        if (optionalArtist.isPresent()){
            System.out.println("Informe o título da música: ");
            var musicTitle = scan.nextLine();

            Music music = new Music(musicTitle);
            music.setArtist(optionalArtist.get());
            optionalArtist.get().getSongs().add(music);
            repository.save(optionalArtist.get());
        } else{
            System.out.println("Artista não cadastrado no banco de dados, tecle 1, cadastre-o e tente novamente.");
        }
    }
    private void listSongs(){
        System.out.println("Informe o artista que deseja listar as músicas");
        var artistName = scan.nextLine();

        optionalArtist = repository.findByNameContainingIgnoreCase(artistName);
        if(optionalArtist.isPresent()) {
            Artist artist = optionalArtist.get();
            List<Music> music = repository.listSongs(artist);
            System.out.println("Músicas do artista '" + artist.getName() + "':");
            music.forEach(m ->
                    System.out.println(m.getTitle()));
        }
    }
    private void searchMusicByArtist(){
        System.out.println("Informe o nome da música para para buscar o artista: ");
        var musicName = scan.nextLine();

        Optional<Music> optionalMusic = repository.searchMusic(musicName);
        if (optionalMusic.isPresent()){
            Music music = optionalMusic.get();
            Artist artist = repository.findArtist(music.getTitle());
            System.out.println("A música '" + music.getTitle() + "' é do artista: " + artist.getName());
        } else {
            System.out.println("Artista ou música não encontrados, tente cadastra-los!");
        }

    }
    private void searchArtistData(){
        System.out.println("Informe o nome do artista que deseja saber mais sobre: ");
        var artistName = scan.nextLine();
        var response = ChatgptQuery.getInfo(artistName);
        System.out.println(response.trim());
    }
}

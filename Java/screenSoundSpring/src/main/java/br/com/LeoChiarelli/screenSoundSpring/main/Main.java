package br.com.LeoChiarelli.screenSoundSpring.main;

import br.com.LeoChiarelli.screenSoundSpring.models.Artist;
import br.com.LeoChiarelli.screenSoundSpring.models.ArtistCategory;
import br.com.LeoChiarelli.screenSoundSpring.models.Music;
import br.com.LeoChiarelli.screenSoundSpring.repository.IArtistRepository;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    Scanner scan = new Scanner(System.in);
    private final IArtistRepository repository;

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
                    5 - Pesquisar dados sobre um artista
                    
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
        Artist artist = new Artist();

        Optional<Artist> optionalArtist = repository.findByNameContainingIgnoreCase(artistName);
        if(optionalArtist.isPresent()) {
            artist.setName(artistName);
            List<Music> music = repository.listOfSongs(artist);
            music.forEach(m ->
                    System.out.printf("Artista: %s \nMúsica: '%s' \n", m.getArtist(), m.getTitle()));
        }
    }
    private void searchMusicByArtist(){

    }
    private void searchArtistData(){

    }
}

package br.com.LeoChiarelli.main;

import br.com.LeoChiarelli.models.*;
import br.com.LeoChiarelli.repository.SerieRepository;
import br.com.LeoChiarelli.service.APIconsumption;
import br.com.LeoChiarelli.service.ConvertsData;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private final Scanner scan = new Scanner(System.in);
    private final APIconsumption consumption = new APIconsumption();
    private final ConvertsData converter = new ConvertsData();
    private final List<SeasonsData> seasonsList = new ArrayList<>();
    private final String URL = "https://www.omdbapi.com/?t="; // Constantes em upperCase
    private final String API_KEY = "&apikey=7c66c456";

    private SerieRepository repository;
    private List<Serie> seriesList = new ArrayList<>();

    public Main(SerieRepository repository) {
        this.repository = repository;
    }

    public void displayMenu() {
        var option = -1;
        while (option != 0) {
            var menu = """
                    1 - Buscar séries
                    2 - Buscar episódios
                    3 - Listar séries buscadas
                    4 - Buscar série por título
                    5 - Buscar série por ator
                    6 - Buscar série por avaliação
                    7 - Buscar série por categoria/gênero
                    8 - Buscar série por temporada
                    9 - Buscar episódio por trecho
                    
                    0 - Sair
                    """;
            System.out.println(menu);
            option = scan.nextInt();
            scan.nextLine();

            switch (option) {
                case 1:
                    searchWebSeries();
                    break;
                case 2:
                    searchEpisodeBySerie();
                    break;
                case 3:
                    listSearchedSeries();
                    break;
                case 4:
                    searchSerieByTitle();
                    break;
                case 5:
                    searchSerieByActor();
                    break;
                case 6:
                    searchSerieByRating();
                    break;
                case 7:
                    searchSerieByGenre();
                    break;
                case 8:
                    searchSerieByTotalSeasons();
                    break;
                case 9:
                    searchEpisodeBySplit();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opcção inválida!");
            }
        }
    }


    private void searchWebSeries() {
        SeriesData data = getSeriesData();
        Serie serie = new Serie(data);
        repository.save(serie); // Injeção de dependências
        System.out.println(data);
    }

    private SeriesData getSeriesData() {
        System.out.print("Digite o nome da série para busca: ");
        var serieName = scan.nextLine();
        String json = consumption.getData(URL + serieName.replace(" ", "+") + API_KEY);
        SeriesData data = converter.getData(json, SeriesData.class);
        return data;
    }

    private void searchEpisodeBySerie() {
        listSearchedSeries();
        System.out.println("Qual série você deseja ver os episódios? ");
        var serieName = scan.nextLine();

        Optional<Serie> searchedSerie = repository.findByTitleContainingIgnoreCase(serieName);

        if(searchedSerie.isPresent()) {

            var foundSerie = searchedSerie.get();
            List<SeasonsData> seasons = new ArrayList<>();

            for (int i = 1; i <= foundSerie.getTotalSeasons(); i++) {
                var json = consumption.getData(URL + foundSerie.getTitle().replace(" ", "+") + "&Season=" + i + API_KEY);
                SeasonsData seasonsData = converter.getData(json, SeasonsData.class);
                seasons.add(seasonsData);
            }
            // seasons.forEach(System.out::println);

            List<Episode> episodes = seasons.stream()
                    .flatMap(d -> d.episodes().stream()
                            .map(e -> new Episode(d.season(), e)))
                    .collect(Collectors.toList());
            foundSerie.setEpisodes(episodes);
            repository.save(foundSerie);
        } else{
            System.out.println("Série não encontrada.");
        }
    }

    private void listSearchedSeries(){
        seriesList = repository.findAll();
        seriesList.stream()
                .sorted(Comparator.comparing(Serie::getGenre))
                .forEach(s ->
                        System.out.printf("Título: '%s' \nAvaliação: %.1f/10 \nTemporadas: %s \nGênero: %s \nAno: %s \nAtores: %s \nEscritor(a): %s \nSinópse: %s", s.getTitle(), s.getRating(), s.getTotalSeasons(), s.getGenre(), s.getYear(), s.getActors(), s.getWriter(), s.getSynopsis()));
    }

    private void searchSerieByTitle() {
        System.out.println("Escolha uma série pelo título: ");
        var serieName = scan.nextLine();

        Optional<Serie> searchedSerie = repository.findByTitleContainingIgnoreCase(serieName);

        if (searchedSerie.isPresent()){
            System.out.printf("""
                        Dados da série:
                        Título: '%s'
                        Temporadas: %s
                        Avaliação: %.1f/10
                        Gênero: %s
                        """, searchedSerie.get().getTitle(), searchedSerie.get().getTotalSeasons(), searchedSerie.get().getRating(), searchedSerie.get().getGenre());
        } else {
            System.out.println("Série não encontrada");
        }
    }

    private void searchSerieByActor(){
        System.out.println("Informe o(a) ator(a) que deseja: ");
        var actorName = scan.nextLine();

        List<Serie> searchedSerie = repository.findByActorsContainingIgnoreCase(actorName);

        System.out.println("Séries nas quais o(a) ator(a) '" + actorName + "' se encontra: ");
        searchedSerie.forEach(s -> System.out.println(s.getTitle()));
    }

    private void searchSerieByRating(){
        System.out.println("Informe a nota que deseja usar como base: ");
        var serieRating = scan.nextDouble();

        List<Serie> searchedSerie = repository.findByRatingGreaterThanEqualOrderByRatingDesc(serieRating);
        System.out.println("Séries nas quais as notas são maiores ou iguals a " + serieRating);
        for (Serie serie: searchedSerie){
            System.out.printf("""
                    Título: %s
                    Avalição: %.1f/10
                    
                    """, serie.getTitle(), serie.getRating());
        }
    }

    private void searchSerieByGenre(){
        System.out.println("Informe o gênero que deseja: ");
        var serieGenre = scan.nextLine();
        Category category = Category.fromPortuguese(serieGenre);

        List<Serie> searchedSerie = repository.findByGenre(category);
        System.out.println("Aqui estão as séries do gênero '" + serieGenre + "':");
        for (Serie serie : searchedSerie){
            System.out.printf("""
                    Título: '%s'
                    Avalição: %.1f/10
                    
                    """, serie.getTitle(), serie.getRating());
        }
    }

    private void searchSerieByTotalSeasons(){
        System.out.println("Informe o número máximo de temporadas que deseja: ");
        var totalSeasons = scan.nextInt();
        System.out.println("Informe a avaliação mínima: ");
        var serieRating = scan.nextDouble();

        List<Serie> searchedSerie = repository.seriesBySeasonsAndRating(totalSeasons, serieRating);
        System.out.println("Aqui estão as séries com as características que você deseja: ");
        for(Serie serie : searchedSerie){
            System.out.printf("""
                    Título: '%s'
                    Total de Temporadas: %d
                    Avaliação: %.1f/10
                    
                    """, serie.getTitle(), serie.getTotalSeasons(), serie.getRating());
        }
    }

    private void searchEpisodeBySplit(){
        System.out.println("Informe um trecho do episódio que deseja: ");
        var splitOfEpisode = scan.nextLine();

        List<Episode> searchedEpisode = repository.episodiesBySplit(splitOfEpisode);
        System.out.println("Aqui estão os episódios encontrados: ");
        searchedEpisode.forEach(e ->
                System.out.printf("Série: %s \nTemporada: %d \nEpisódio: %s \nTítulo: '%s'", e.getSerie(), e.getTemporada(), e.getEpisode(), e.getTitle()));
        }
    }

// '->' ou '::' - são lambdas, chamadas de funções anônimas - são uma maneira de definir funções que são frequentemente usadas uma única vez, direto no local onde elas serão usadas.
// (argumentos) -> { corpo-da-função }
// (a, b) -> { return a + b; }
// List<Integer> lista = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
// lista.stream().filter(i -> i % 2 == 0).forEach(System.out::println);

// 'stream' - fluxo de dados
// 'peek' - verifcar cada etapa do código
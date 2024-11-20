package br.com.LeoChiarelli.main;

import br.com.LeoChiarelli.models.Episode;
import br.com.LeoChiarelli.models.SeasonsData;
import br.com.LeoChiarelli.models.Serie;
import br.com.LeoChiarelli.models.SeriesData;
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

        Optional<Serie> serieOptional = seriesList.stream()
                .filter(s -> s.getTitle().toUpperCase().contains(serieName.toUpperCase()))
                .findFirst();

        if(serieOptional.isPresent()) {

            var foundSerie = serieOptional.get();
            List<SeasonsData> seasons = new ArrayList<>();

            for (int i = 1; i <= foundSerie.getTotalSeasons(); i++) {
                var json = consumption.getData(URL + foundSerie.getTitle().replace(" ", "+") + "&Season=" + i + API_KEY);
                SeasonsData seasonsData = converter.getData(json, SeasonsData.class);
                seasons.add(seasonsData);
            }
            seasons.forEach(System.out::println);

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
                .forEach(System.out::println);
    }

}


// '->' ou '::' - são lambdas, chamadas de funções anônimas - são uma maneira de definir funções que são frequentemente usadas uma única vez, direto no local onde elas serão usadas.
// (argumentos) -> { corpo-da-função }
// (a, b) -> { return a + b; }
// List<Integer> lista = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
// lista.stream().filter(i -> i % 2 == 0).forEach(System.out::println);

// 'stream' - fluxo de dados
// 'peek' - verifcar cada etapa do código
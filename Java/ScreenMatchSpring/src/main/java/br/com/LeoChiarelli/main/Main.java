package br.com.LeoChiarelli.main;

import br.com.LeoChiarelli.models.Episode;
import br.com.LeoChiarelli.models.EpisodesData;
import br.com.LeoChiarelli.models.SeasonsData;
import br.com.LeoChiarelli.models.SeriesData;
import br.com.LeoChiarelli.service.APIconsumption;
import br.com.LeoChiarelli.service.ConvertsData;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private final Scanner scan = new Scanner(System.in);
    private final APIconsumption consumption = new APIconsumption();
    private final ConvertsData converter = new ConvertsData();
    private final List<SeasonsData> SeasonsList = new ArrayList<>();

    private final String URL = "https://www.omdbapi.com/?t="; // Constantes em upperCase
    private final String API_KEY = "&apikey=7c66c456";
    private List<SeriesData> listSeriesData = new ArrayList<>();

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
        listSeriesData.add(data);
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
        SeriesData seriesData = getSeriesData();
        List<SeasonsData> seasons = new ArrayList<>();

        for (int i = 1; i <= seriesData.totalSeasons(); i++) {
            var json = consumption.getData(URL + seriesData.title().replace(" ", "+") + "&Season=" + i + API_KEY);
            SeasonsData seasonsData = converter.getData(json, SeasonsData.class);
            SeasonsList.add(seasonsData);
        }
        SeasonsList.forEach(System.out::println);
    }

    private void listSearchedSeries(){
        listSeriesData.forEach(System.out::println);
    }
}


// '->' ou '::' - são lambdas, chamadas de funções anônimas - são uma maneira de definir funções que são frequentemente usadas uma única vez, direto no local onde elas serão usadas.
// (argumentos) -> { corpo-da-função }
// (a, b) -> { return a + b; }
// List<Integer> lista = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
// lista.stream().filter(i -> i % 2 == 0).forEach(System.out::println);

// 'stream' - fluxo de dados
// 'peek' - verifcar cada etapa do código
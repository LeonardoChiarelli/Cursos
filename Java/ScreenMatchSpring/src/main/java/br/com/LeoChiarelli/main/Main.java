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
    private final Scanner leitor = new Scanner(System.in);
    private final APIconsumption consumoAPI = new APIconsumption();
    private final ConvertsData conversor = new ConvertsData();
    private final List<SeasonsData> listaTemporadas = new ArrayList<>();

    private final String ENDERECO = "https://www.omdbapi.com/?t="; // Constantes em upperCase
    private final String API_KEY = "&apikey=7c66c456";

    public void displayMenu(){
        System.out.print("Digite o nome da série para busca: ");
        var nomeSerie = leitor.nextLine();
        String json = consumoAPI.getData(ENDERECO + nomeSerie.replace(" ", "+") + API_KEY);

        SeriesData dadosSerie = conversor.getData(json, SeriesData.class);
        System.out.println(dadosSerie);

        for (int i = 1; i<=dadosSerie.totalSeasons(); i++){
            json = consumoAPI.getData(ENDERECO + nomeSerie.replace(" ", "+") + "&Season=" + i + API_KEY);
            SeasonsData dadosTemporada = conversor.getData(json, SeasonsData.class);
            listaTemporadas.add(dadosTemporada);
        }
        listaTemporadas.forEach(System.out::println);

        listaTemporadas.forEach(t -> t.episodes().forEach(e -> System.out.println("Temporada " + t.season() +" ;Episódio " + e.episode() + ": '"+ e.title() + "'")));
        // Para toda temporada 't' vamos pegar os episódios -> Para cada episódio 'e' vamos imprimir o número da temporada (t.season()), o número do episódio (e.episode()) e o título de cada episódio (e.title())

        List<EpisodesData> dadosEpisodios = listaTemporadas.stream()
                .flatMap(t -> t.episodes().stream())
                .collect(Collectors.toList());
        // .toList() gera uma lista imutável

        System.out.println("\nTop 5 episódios: ");
        dadosEpisodios.stream()
                .filter(e -> !e.rating().equalsIgnoreCase("N/A"))
                .sorted(Comparator.comparing(EpisodesData::rating).reversed())
                .limit(5)
                .forEach(e ->  System.out.println("- Episódio " + e.episode() + "; Título: '" + e.title() + "'; Nota: " + e.rating()));

        List<Episode> episodios = listaTemporadas.stream()
                .flatMap(t -> t.episodes().stream()
                        .map(d -> new Episode(t.season(), d))
                ).collect(Collectors.toList());

        episodios.forEach(System.out::println);


        System.out.println("Informe o trecho do título que deseja buscar: ");
        var trechoTitulo = leitor.nextLine();
        Optional<Episode> episodioBuscado = episodios.stream() // 'Optional<>' - espécie de container // atribuindo o trecho à uma variável
                .filter(e -> e.getTitle().toUpperCase().contains(trechoTitulo.toUpperCase())) // se o título do episódio contiver (contains()) o que foi passado pelo usuário
                .findFirst(); // 'findAny()' para um resultado mais rápido, porém menos preciso ; 'findFirst()' - para pegar sempre o mesmo resultado
        if(episodioBuscado.isEmpty()){ // para verificar se a variável está vazia
            System.out.println("Episódio não encotrado! Verifique a digitação");
        }else{
            System.out.println("Temporada: " + episodioBuscado.get().getTemporada() + "\nEpisódio número " + episodioBuscado.get().getEpisode());
        }


        System.out.println("À partir de que ano você deseja ver os episódios? ");
        var ano = leitor.nextInt();
        leitor.nextLine();

        LocalDate dataBusca = LocalDate.of(ano, 1, 1);

        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        episodios.stream()
                .filter(e -> e.getDataLancamento() != null && e.getDataLancamento().isAfter(dataBusca)) // Queremos uma data que seja posterior à data informada pelo usuário 'isAfter()'
                .forEach(e -> System.out.println(
                        "Temporada " + e.getTemporada() + "\n" +
                                "Episódio " + e.getEpisode() + "\n" +
                                "Título: '" +e.getTitle() + "'\n" +
                                "Data de Lançamento: " + e.getDataLancamento().format(formatador) + "\n"
                ));

        Map<Integer, Double> avaliacoesPorTem = episodios.stream()
                .filter(e -> e.getRating() > 0.0)
                .collect(Collectors.groupingBy(Episode::getTemporada, Collectors.averagingDouble(Episode::getRating))); // Coletamos os episódios e agrupamos por temporada e mostrar a média de avalições de cada temporada
        // System.out.println(avaliacoesPorTem);

        DoubleSummaryStatistics est = episodios.stream()
                .filter(e -> e.getRating() > 0.0)
                .collect(Collectors.summarizingDouble(Episode::getRating));
        System.out.printf("""
                Média de avaliações: %.2f/10
                Menor avaliação: %.2f/10
                Maior avaliação: %.2f/10
                Foram avaliados %d episódios para a montagem das estatísticas
                """, est.getAverage(), est.getMin(), est.getMax(), est.getCount());
    }
}

// '->' ou '::' - são lambdas, chamadas de funções anônimas - são uma maneira de definir funções que são frequentemente usadas uma única vez, direto no local onde elas serão usadas.
// (argumentos) -> { corpo-da-função }
// (a, b) -> { return a + b; }
// List<Integer> lista = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
// lista.stream().filter(i -> i % 2 == 0).forEach(System.out::println);

// 'stream' - fluxo de dados
// 'peek' - verifcar cada etapa do código
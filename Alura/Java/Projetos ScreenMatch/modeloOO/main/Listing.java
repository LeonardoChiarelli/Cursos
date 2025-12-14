package br.com.LeoChiarelli.screenMatch.modeloOO.main;

import br.com.LeoChiarelli.screenMatch.modeloOO.models.Movie;
import br.com.LeoChiarelli.screenMatch.modeloOO.models.Serie;
import br.com.LeoChiarelli.screenMatch.modeloOO.models.Title;

import java.util.*;

public class Listing {
    public static void main(String[] args) {
        // FILMES
        Movie filme01 = new Movie("Top Gun: Maverick", 2022,  102, "Joseph Kosinski");
        filme01.setInclusoNoPlano(true);
        filme01.avalia(9);

        Movie filme02 = new Movie("O Podereso Chefão", 1980,  104, "Francis Ford Coppola");
        filme02.setInclusoNoPlano(false);
        filme02.avalia(6);

        var filme03 = new Movie("Vingadores: Ultimato", 2022, 196, "Anthony e Joe Russo"); //
        filme03.setInclusoNoPlano(true);
        filme03.avalia(10);
        Movie f1 = filme03; // Variável de referência (duas variáveis estão apontando para o mesmo objeto)

        Movie filme04 = new Movie("Invocação do Mal", 2013, 112, "James Wan");
        filme04.setInclusoNoPlano(true);
        filme04.avalia(9.4);

        // SERIES
        Serie serie01 = new Serie("Suits", 2020, 10, 12, 47);
        serie01.setAtiva(true);
        serie01.setInclusoNoPlano(true);

        // LISTA
        ArrayList<Title> lista = new ArrayList<>();
        lista.add(filme01);
        lista.add(filme02);
        lista.add(filme03);
        lista.add(filme04);
        lista.add(serie01);

        for (Title item: lista){ // Para cada título da lista
            System.out.println(item);
            if (item instanceof Movie filme && filme.getClassificacao() > 2){ // perguntando ao item se ele é uma instância de Movie (prática não recomendada)
                // À partir do java 14 a variável pode ser delcarada junto à pergunta (if)
                // À partir do java 17 podemos fazer um pattern matching (verificações com operadores lógicos)
                System.out.printf("Classificação: %d/5\n", filme.getClassificacao());
            }
        }

        // LISTA ORDENADA
        List<String> buscaArtista = new LinkedList<>(); // 'List' - forma mais usada do 'ArrayList' // 'LinkedList' - mais rápida ou gasta menos memória
        buscaArtista.add("Adam Sandler");
        buscaArtista.add("Paulo");
        buscaArtista.add("Jaqueline");
        buscaArtista.add("Leonardo");
        Collections.sort(buscaArtista); // Coloca a lista em ordem alfabética
        System.out.println(buscaArtista);

        Collections.sort(lista); // Comparable - interface que diz que todos or argumentos dentro dela precisam ser compráveis uns com os outros
        System.out.println("Lista de títulos em ordem alfabética: " + lista);

        lista.sort(Comparator.comparing(Title::getAnoDeLancamento)); // Para usar o Comparator - outra interface - '::' sintaxe para trabalhar com os lambdas
        System.out.println("Lista de títulos em ordem de ano de lançamento: " + lista);
    }
}
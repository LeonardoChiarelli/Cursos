package br.com.LeoChiarelli.screenMatch.modeloAPI.principal;

import br.com.LeoChiarelli.screenMatch.modeloAPI.modelos.Movie;
import br.com.LeoChiarelli.screenMatch.modeloAPI.modelos.Serie;
import br.com.LeoChiarelli.screenMatch.modeloAPI.modelos.Titulo;

import java.util.*;

public class Listagem {
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
        Movie f1 = filme03;

        Movie filme04 = new Movie("Invocação do Mal", 2013, 112, "James Wan");
        filme04.setInclusoNoPlano(true);
        filme04.avalia(9.4);

        // SERIES
        Serie serie01 = new Serie("Suits", 2020, 10, 12, 47);
        serie01.setAtiva(true);
        serie01.setInclusoNoPlano(true);

        // LISTA
        ArrayList<Titulo> lista = new ArrayList<>();
        lista.add(filme01);
        lista.add(filme02);
        lista.add(filme03);
        lista.add(filme04);
        lista.add(serie01);

        for (Titulo item: lista){ // Para cada título da lista
            System.out.println(item);
            if (item instanceof Movie filme && filme.getClassificacao() > 2){
                System.out.printf("Classificação: %d/5\n", filme.getClassificacao());
            }
        }

        // LISTA ORDENADA
        List<String> buscaArtista = new LinkedList<>();
        buscaArtista.add("Adam Sandler");
        buscaArtista.add("Paulo");
        buscaArtista.add("Jaqueline");
        buscaArtista.add("Leonardo");
        Collections.sort(buscaArtista);
        System.out.println(buscaArtista);

        Collections.sort(lista);
        System.out.println("Lista de títulos em ordem alfabética: " + lista);

        lista.sort(Comparator.comparing(Titulo::getAnoDeLancamento));
        System.out.println("Lista de títulos em ordem de ano de lançamento: " + lista);
    }
}

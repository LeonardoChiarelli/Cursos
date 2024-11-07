package br.com.LeoChiarelli.screenMatch.modeloAPI.principal;

import br.com.LeoChiarelli.screenMatch.modeloAPI.calculos.CalculadoraTempo;
import br.com.LeoChiarelli.screenMatch.modeloAPI.classificacao.Recomendacao;
import br.com.LeoChiarelli.screenMatch.modeloAPI.modelos.Episodio;
import br.com.LeoChiarelli.screenMatch.modeloAPI.modelos.Movie;
import br.com.LeoChiarelli.screenMatch.modeloAPI.modelos.Serie;
import br.com.LeoChiarelli.screenMatch.modeloAPI.modelos.Titulo;

import java.util.ArrayList;

public class Main{
    public static void main(String[] args) {
        // FILME

        Movie filme01 = new Movie("Top Gun: Maverick", 2022,  102, "Joseph Kosinski");
        filme01.setInclusoNoPlano(true);

        filme01.avalia(8.2);
        filme01.avalia(10);
        filme01.avalia(9.4);
        filme01.avalia(3.2);
        // filme01.exibeFichaTecnica();

        Movie filme02 = new Movie("O Podereso Chefão", 1980,  104, "Francis Ford Coppola");
        filme02.setInclusoNoPlano(false);

        filme02.avalia(9);
        filme02.avalia(10);
        filme02.avalia(5.1);
        filme02.avalia(7.3);
        filme02.avalia(6);
        // filme02.exibeFichaTecnica();

        var filme03 = new Movie("Vingadores: Ultimato", 2022, 196, "Anthony e Joe Russo"); // 'var' - Inferência do tipo declarado
        filme03.setInclusoNoPlano(true);

        filme03.avalia(10);
        filme03.avalia(9.3);
        filme03.avalia(9.1);
        filme03.avalia(8.7);
        // filme03.exibeFichaTecnica();


        // SERIE / EPISÓDIOS

        Serie serie01 = new Serie("Suits", 2020, 10, 12, 47);
        serie01.setAtiva(true);
        serie01.setInclusoNoPlano(true);

        serie01.avalia(8.2);
        serie01.avalia(10);
        serie01.avalia(9.4);
        serie01.avalia(3.2);
        // serie01.exibeFichaTecnica();

        Episodio episodio01Serie01 = new Episodio();
        episodio01Serie01.setNumero(1);
        episodio01Serie01.setSerie(serie01);
        episodio01Serie01.setTotalVisualizacoes(101);


        // CALCULADORA TEMPO

        CalculadoraTempo calcular = new CalculadoraTempo();
        // calcular.inclui(filme01);
        // calcular.inclui(serie01);
        // System.out.println("O tempo total em minutos é de " + calcular.getTempoTotal());


        // FILTRO RECOMENDAÇÃO
        Recomendacao filtro = new Recomendacao();
        // filtro.filtraRecomendacao(filme01);
        // filtro.filtraRecomendacao(episodio01Serie01);


        // ArrayList de Titulos
        ArrayList<Titulo> listaDeTitulos = new ArrayList<>();
        listaDeTitulos.add(filme01);
        listaDeTitulos.add(filme02);
        listaDeTitulos.add(filme03);
        System.out.println("Tamanho da lista: " + listaDeTitulos.size());
        System.out.printf("""
                %s
                %s
                %s
                """, listaDeTitulos.get(0).toString(), listaDeTitulos.get(1).toString(), listaDeTitulos.get(2).toString());

    }
}

// API - Application Programming Interface
// JSON - JavaScript Object Notation - composto por dois tipos de estrutura de dados: objetos e arrays
    // Obejto - coleção de pares de chave-valor, onde as chaves são strings e os valores podems ser strings, números, booleanos, objetos ou arrays
    // Array - coleção ordenada de valores, que podem ser strings, números, booleanos, objetos ou outros arrays
// APIKey - chave de acesso da API
// Postman - ferramenta


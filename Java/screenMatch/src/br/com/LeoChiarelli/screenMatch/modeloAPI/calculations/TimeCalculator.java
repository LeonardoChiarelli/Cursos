package br.com.LeoChiarelli.screenMatch.modeloAPI.calculations;

import br.com.LeoChiarelli.screenMatch.modeloAPI.models.Title;

public class TimeCalculator {
    private int tempoTotal;

    // GETTERS
    public int getTempoTotal(){
        return tempoTotal;
    }

    // METODO

    public void inclui(Title t){ // PRIOZIANDO O DESIGN DE CLASSES PASSANDO COMO PARÂMETRO A SUPER CLASSE
        System.out.println("Adicionando duração em minutos de '" + t.getNome() + "'");
        tempoTotal += t.getDuracaoEmMinutos();
    }
}
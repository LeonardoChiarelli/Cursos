package br.com.LeoChiarelli.screenMatch.modeloAPI.calculos;

import br.com.LeoChiarelli.screenMatch.modeloAPI.modelos.Titulo;

public class CalculadoraTempo {
    private int tempoTotal;

    // GETTERS
    public int getTempoTotal(){
        return tempoTotal;
    }

    // METODO

    public void inclui(Titulo t){
        System.out.println("Adicionando duração em minutos de '" + t.getNome() + "'");
        tempoTotal += t.getDuracaoEmMinutos();
    }
}

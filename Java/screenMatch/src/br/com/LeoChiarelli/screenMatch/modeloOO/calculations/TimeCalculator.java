package br.com.LeoChiarelli.screenMatch.modeloOO.calculations;
import br.com.LeoChiarelli.screenMatch.modeloOO.models.Title;

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

/*
REFERENTE A DESIGN DE CLASSES (linha 16)

metodo inviável pois toda hora teríamos que criar outra função para adicionar outro título

     public void inclui(Movie f){
        tempoTotal += f.getDuracaoEmMinutos();
    }
    public void inclui(Serie s){ // SOBRECARGA DE METODO
        tempoTotal += s.getDuracaoEmMinutos();
    }
*/
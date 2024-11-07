package br.com.LeoChiarelli.screenMatch.modeloAPI.models;
import br.com.LeoChiarelli.screenMatch.modeloAPI.classification.Classification;

public class Episode extends Title implements Classification {
    private int numero;
    private String nome;
    private Serie serie;
    private double minutos;
    private int totalVisualizacoes;

    // GETTERS
    public int getNumero(){
        return numero;
    }
    public String getNome(){
        return nome;
    }
    public Serie getSerie(){
        return serie;
    }
    public double getMinutos(){
        return minutos;
    }
    public int getTotalVisualizacoes(){
        return totalVisualizacoes;
    }

    @Override
    public int getClassificacao(){
        if (totalVisualizacoes > 100){
            return 4;
        } else {
            return 2;
        }
    }

    // SETTERS
    public void setNumero(int numero){
        this.numero = numero;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setSerie(Serie serie){
        this.serie = serie;
    }
    public void setMinutos(double minutos){
        this.minutos = minutos;
    }
    public void setTotalVisualizacoes(int visualizacoes){
        this.totalVisualizacoes = visualizacoes;
    }
}
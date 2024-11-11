package br.com.LeoChiarelli.screenMatch.modeloAPI.models;

import br.com.LeoChiarelli.screenMatch.modeloAPI.exceptions.ErroDeConversaoException;
import com.google.gson.annotations.SerializedName;

public class Title implements Comparable<Title>{
    private String nome;
    private int anoDeLancamento;
    private boolean inclusoNoPlano;
    private double somaDasAvaliacoes;
    private int totalDeAvaliacoes;
    private int duracaoEmMinutos;

    public Title(){

    }

    public Title(String nome, int anoDeLancamento) {
        this.nome = nome;
        this.anoDeLancamento = anoDeLancamento;
    }

    public Title(TitleOMBD meuTituloOmbd) { // Constructor para receber um titleOmdb
        this.nome = meuTituloOmbd.title();

        if(meuTituloOmbd.year().length() > 4){
            throw new ErroDeConversaoException("Não consegui converter o ano, pois tem mais de 4 caracteres"); // podemos criar erros específicos
        }
        this.anoDeLancamento = Integer.valueOf(meuTituloOmbd.year()); // 'pegue o valor de year e tente converter em um inteiro'
        this.duracaoEmMinutos = Integer.parseInt(meuTituloOmbd.runtime().substring(0,3)); // outra maneira de fazer a mesma coisa // 'substring' - metodo para retirar partes de uma string, primeiro número onde começa e último número até onde vai
    }


    public String getNome(){
        return nome;
    }

    public int getAnoDeLancamento(){
        return anoDeLancamento;
    }

    public boolean getInclusoNoPlano(){
        return inclusoNoPlano;
    }

    public int getTotalDeAvaliacoes(){
        return totalDeAvaliacoes;
    }

    public int getDuracaoEmMinutos(){
        return duracaoEmMinutos;
    }

    // SETTERS

    protected void setAnoDeLancamento(int anoDeLancamento){
        this.anoDeLancamento = anoDeLancamento;
    }

    protected void setDuracaoEmMinutos(int duracaoEmMinutos){
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    public void setInclusoNoPlano(boolean inclusoNoPlano) {
        this.inclusoNoPlano = inclusoNoPlano;
    }

    // METODO

    public void exibeFichaTecnica(){
        System.out.printf("""
                Nome: %s
                Ano de Lançamento: %d
                Incluso no plano: %s
                Avaliaçao: %.1f/10
                Total de avaliações: %d
                Duração: %d minutos
                """, getNome(), getAnoDeLancamento(), this.isInclusoNoPlano(), this.fazMedia(), getTotalDeAvaliacoes(), getDuracaoEmMinutos());
    }

    public void avalia(double nota){
        somaDasAvaliacoes += nota;
        totalDeAvaliacoes++;
    }
    protected double fazMedia(){ // Se a função devolver algo, colocar o tipo primitivo da devolução e o 'return'
        return somaDasAvaliacoes/totalDeAvaliacoes;
    }

    public String isInclusoNoPlano(){
        if (getInclusoNoPlano()){
            return "Sim";
        } else {
            return "Não";
        }
    }

    @Override
    public String toString() {
        return "(Nome: " + nome + "\n" +
                "Ano de lançamento: " + anoDeLancamento + "\n" +
                "Duração: " + duracaoEmMinutos + ")";
    }

    @Override
    public int compareTo(Title outroTitulo) {
        return this.getNome().compareTo(outroTitulo.getNome());
    }
}


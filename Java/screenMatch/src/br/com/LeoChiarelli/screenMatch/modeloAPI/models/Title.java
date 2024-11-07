package br.com.LeoChiarelli.screenMatch.modeloAPI.models;

public class Title implements Comparable<Title>{
    private String nome; // ENCAPSULAMENTO
    private int anoDeLancamento;
    private boolean inclusoNoPlano;
    private double somaDasAvaliacoes;
    private int totalDeAvaliacoes;
    private int duracaoEmMinutos;

    // CONSTRUCTOR
    public Title(){

    }

    public Title(String nome, int anoDeLancamento) {
        this.nome = nome;
        this.anoDeLancamento = anoDeLancamento;
    }


    // GETTERS

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

    protected void setNome(String nome){ // Mudamos para 'protected' para deixar apenas as subclasses alterarem o nome do filme
        this.nome = nome;
    }

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
    public int compareTo(Title outroTitulo) {
        return this.getNome().compareTo(outroTitulo.getNome());
    }
}


// HERANÇA

package br.com.LeoChiarelli.screenMatch.modeloOO.models;

public class Title implements Comparable<Title>{
    // ABSTRAÇÃO

    private String nome; // ENCAPSULAMENTO
    private int anoDeLancamento;
    private boolean inclusoNoPlano;
    private double somaDasAvaliacoes;
    private int totalDeAvaliacoes;
    private int duracaoEmMinutos;

    // CONSTRUCTOR
    public Title(){ // constructor default - para corrigir o erro em 'Episodio' -

    }

    public Title(String nome, int anoDeLancamento) {
        this.nome = nome;
        this.anoDeLancamento = anoDeLancamento;
    }


    // GETTERS - busca valores

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

    // SETTERS - modifica valores

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

    public void exibeFichaTecnica(){ // Em java caso a função não devolva nada para quem chamou ela, necessitamos colocar o 'void'
        System.out.printf("""
                Nome: %s
                Ano de Lançamento: %d
                Incluso no plano: %s
                Avaliaçao: %.1f/10
                Total de avaliações: %d
                Duração: %d minutos
                """, getNome(), getAnoDeLancamento(), this.isInclusoNoPlano(), this.fazMedia(), getTotalDeAvaliacoes(), getDuracaoEmMinutos());
    }

    public void avalia(double nota){ // Ao usar o package precisamos deixar explícito quais métodos são públicos, default, privados ou protegidos
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

    @Override // Metodo da interface 'Comparable'
    public int compareTo(Title outroTitulo) {
        return this.getNome().compareTo(outroTitulo.getNome());
    }
}

// Pacotes são utilizados para organizar o código de acordo com a sua funcionalidade
// São escritos de trás pra frente (domínio reverso) 'br.com.LeoChiarelli.sreenMatch'
// Pacote raiz é o pacote principal
// Import - mostrar de onde estamos usando as classes, métodos, entre outros
// Em java e outras linguagens modernas que seguem os principios de OO, a herança só pode ser estabelicida a partir de uma Classe
// Embora seja opcional, o construtor default é importante para que objetos da classe possam ser criados sem a necessidade de fornecer parâmetros, permitindo assim uma maior flexibilidade.


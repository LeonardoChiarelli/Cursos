package br.com.LeoChiarelli.screenMatch.modeloAPI.modelos;

import br.com.LeoChiarelli.screenMatch.modeloAPI.classificacao.Classificacao;

public class Movie extends Titulo implements Classificacao {
    private String diretor;

    // CONSTRUCTOR
    public Movie(String nome, int anoDeLancamento, int duracaoEmMinutos, String diretor){
        super(nome, anoDeLancamento);
        this.setAnoDeLancamento(anoDeLancamento);
        this.setDuracaoEmMinutos(duracaoEmMinutos);
        this.setDiretor(diretor);
    }

    // GETTERS
    public String getDiretor(){
        return diretor;
    }

    @Override
    public int getClassificacao(){
        return (int) fazMedia() / 2;
    }

    // SETTERS
    private void setDiretor(String diretor){ // Mudamos para 'private' pois o diretor do filme não pode ser mudado depois
        this.diretor = diretor;
    }

    // METODO
    @Override
    public String toString(){ // Sobrescrição do metodo 'toString()' da classe-mãe object (padrão do java)
        return "Filme: '" + this.getNome() + "'(" + this.getAnoDeLancamento() + ")";
    }
}
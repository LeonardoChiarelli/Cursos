package br.com.LeoChiarelli.screenMatch.modeloOO.models;
import br.com.LeoChiarelli.screenMatch.modeloOO.classification.Classification;

public class Movie extends Title implements Classification { // 'extends' - palavra reservada que aplica uma herança à uma classe
    private String diretor;

    // CONSTRUCTOR
    public Movie(String nome, int anoDeLancamento, int duracaoEmMinutos, String diretor){
        super(nome, anoDeLancamento); // chamando o construtor da classe-mãe
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

// Usaremos a Classificação como 'interface' para poder usa-la em 'Movie'
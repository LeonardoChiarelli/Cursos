package br.com.LeoChiarelli.screenMatch.modeloAPI.modelos;

public class Serie extends Titulo {
    private int temporadas;
    private int episodiosPorTemporada;
    private boolean ativa;
    private int minutosPorEpisodio;

    // CONSTRUCTOR
    public Serie(String nome, int anoDeLancamento, int temporadas, int episodiosPorTemporada, int minutosPorEpisodio){
        super(nome, anoDeLancamento);
        this.setTemporadas(temporadas);
        this.setEpisodiosPorTemporada(episodiosPorTemporada);
        this.setMinutosPorEpisodio(minutosPorEpisodio);
    }

    // GETTERS
    public int getTemporadas() {
        return temporadas;
    }

    public int getEpisodiosPorTemporada() {
        return episodiosPorTemporada;
    }

    public boolean getAtiva() {
        return ativa;
    }

    public int getMinutosPorEpisodio() {
        return minutosPorEpisodio;
    }

    @Override
    public int getDuracaoEmMinutos() {
        return temporadas * episodiosPorTemporada * minutosPorEpisodio;
    }

    // SETTERS
    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    public void setEpisodiosPorTemporada(int episodiosPorTemporada) {
        this.episodiosPorTemporada = episodiosPorTemporada;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    public void setMinutosPorEpisodio(int minutosPorEpisodio) {
        this.minutosPorEpisodio = minutosPorEpisodio;
    }

    // MÉTODOS

    public String isAtiva(){
        if (getAtiva()) {
            return "Sim";
        } else {
            return "Não";
        }
    }
    @Override
    public String toString(){ // Sobrescrição do metodo 'toString()' da classe-mãe object (padrão do java)
        return "Série: '" + this.getNome() + "'(" + this.getAnoDeLancamento() + ")";
    }
}

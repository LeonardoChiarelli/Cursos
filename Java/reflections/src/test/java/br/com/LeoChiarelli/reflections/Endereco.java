package br.com.LeoChiarelli.reflections;

public class Endereco {
    private String rua;
    private int numero;

    public Endereco(String rua, int numero) {
        this.rua = rua;
        this.numero = numero;
    }

    public Endereco(){}

    public String getRua() {
        return rua;
    }

    public int getNumero() {
        return numero;
    }
}

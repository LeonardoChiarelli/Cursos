package br.com.LeoChiarelli.livraria;

import java.time.LocalDate;

public class Livro {
    private String nome;
    private String autor;
    private LocalDate dataLancamento;
    private boolean reservado;

    public Livro(String nome, String autor, LocalDate dataLancamento) {
        this.nome = nome;
        this.autor = autor;
        this.dataLancamento = dataLancamento;
        this.reservado = false;
    }

    public String getNome() {
        return nome;
    }

    public String getAutor() {
        return autor;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public boolean getReservado() {
        return reservado;
    }

    public void reservar(){
        this.reservado = true;
    }
}

package br.com.LeoChiarelli.livraria;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args){

        var livro = new Livro("Crônicas de Nárnia", "C. S. Lewis", LocalDate.of(1950, 10, 16));
        var operacao  = new ReservarLivro(livro);

        Thread reservarLeonardo = new Thread(operacao, "Leonardo");
        Thread reservarMaria = new Thread(operacao, "Maria");

        reservarLeonardo.start();
        reservarMaria.start();

        try {
            reservarLeonardo.join();
            reservarMaria.join();
        } catch (InterruptedException e){
            System.out.println(e.getMessage());
        }

        System.out.println("Finalizando reservas!");
    }
}

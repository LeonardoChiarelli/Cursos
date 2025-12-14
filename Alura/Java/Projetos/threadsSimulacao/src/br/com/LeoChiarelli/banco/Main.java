package br.com.LeoChiarelli.banco;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args){
        var cliente = new Cliente("Leonardo");
        var conta = new Conta(cliente, new BigDecimal("550"));

        var operacao = new OperacaoSaque(conta, new BigDecimal("150")); // Transformamos a classe em Runnable

        Thread saqueLeonardo = new Thread(operacao);
        Thread saqueMaria = new Thread(operacao);

        saqueLeonardo.start();
        saqueMaria.start();

        try {
            saqueLeonardo.join(); // faz com que a thread 'main' espere os métodos (threads) serem executados para depois finalizar
            saqueMaria.join();
        } catch (InterruptedException e){
            System.out.println(e.getMessage());
        }

        System.out.println(Thread.currentThread().getName());
        System.out.println("Saldo final: " + conta.getSaldo());
    }
}

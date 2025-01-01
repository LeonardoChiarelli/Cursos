package br.com.LeoChiarelli;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args){
        var cliente = new Cliente("Leonardo");
        var conta = new Conta(cliente, new BigDecimal("150"));

        var operacao = new OperacaoSaque(conta, new BigDecimal("150")); // Transformamos a classe em Runnable

        Thread saqueLeonardo = new Thread(operacao);
        Thread saqueMaria = new Thread(operacao);

        saqueLeonardo.start();
        saqueMaria.start();
    }
}

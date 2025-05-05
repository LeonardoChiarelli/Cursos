package br.com.LeoChiarelli.banco;

import java.math.BigDecimal;

public class OperacaoSaque implements Runnable {

    private Conta conta;
    private BigDecimal valor;

    public OperacaoSaque(Conta conta, BigDecimal valor) {
        this.conta = conta;
        this.valor = valor;
    }

    @Override
    public synchronized void run() { // A palavra-chave 'synchronized' serve para impedir que mais de uma thread acesse simultaneamente uma parte crítica do código ou um recurso compartilhado.

        System.out.println("Iniciando operação de saque.");
        var saldoAtual = conta.getSaldo();

        if (saldoAtual.compareTo(valor) >= 0) {
            System.out.println("Debitando valor de R$" + valor + " da conta");
            conta.debitaSaldo(valor);
            System.out.println("Saldo atual: " + conta.getSaldo());
        } else if (saldoAtual.compareTo(valor) <= 0) {
            throw new IllegalArgumentException("Um saque já foi feito no valor de R$" + valor + ", seu saldo  de (R$" + saldoAtual + ") é insuficiente para realizar esta transação");
        }

        System.out.println("Finalizando operação de saque.");

        System.out.println(Thread.currentThread().getName());
    }
}



package br.com.LeoChiarelli;

import java.math.BigDecimal;

public class Conta{

    private Cliente cliente;
    private BigDecimal saldo;

    public Conta(Cliente cliente, BigDecimal saldoInicial) {
        this.cliente = cliente;
        this.saldo = saldoInicial;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void debitaSaldo(BigDecimal valor) {
        this.saldo = this.saldo.subtract(valor);
    }
}

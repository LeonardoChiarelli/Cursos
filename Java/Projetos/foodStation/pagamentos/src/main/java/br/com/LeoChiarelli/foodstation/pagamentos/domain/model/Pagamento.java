package br.com.LeoChiarelli.foodstation.pagamentos.domain.model;

import br.com.LeoChiarelli.foodstation.pagamentos.domain.dto.CadastrarPagamentoDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity(name = "Pagamento")
@Table(name = "pagamentos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal valor;
    private String nome;
    private String numero;
    private LocalDate expiracao;
    private String codigo;

    @Enumerated(EnumType.STRING)
    private Status status;

    @JoinColumn(name = "pedido_id")
    private Long pedidoId;

    @JoinColumn(name = "forma_de_pagamento_id")
    private Long formaDePagamentoId;

    public Pagamento(CadastrarPagamentoDTO dto) {
        this.id = null;
        this.valor = dto.valor();
        this.nome = dto.nome();
        this.numero = dto.numero();
        this.expiracao = dto.expiracao();
        this.codigo = dto.codigo();
        this.status = Status.CRIADO;
        this.pedidoId = dto.idPedido();
        this.formaDePagamentoId = dto.idFormaDePagamento();
    }

    public void atualizarStatus() {
        this.status = Status.CONFIRMADO;
    }

    public void cancelar() {
        this.status = Status.CANCELADO;
    }
}

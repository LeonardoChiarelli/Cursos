package br.com.LeoChiarelli.adopetThreads.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity(name = "ItemPedido")
@Table(name = "itens_pedidos")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class ItemPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @ManyToOne
    private Pedido pedido;

    @ManyToOne
    private Produto produto;

    private Integer quantidade;
    private BigDecimal precoUnitario;

    public ItemPedido(Pedido pedido, Produto produto, Integer quantidade) {
        this.pedido = pedido;
        this.produto = produto;
        this.quantidade = quantidade;
        this.precoUnitario = produto.getPreco();
    }

    @Override
    public String toString() {
        return "ItemPedido{" +
                "produto=" + produto +
                ", quantidade=" + quantidade +
                '}';
    }
}

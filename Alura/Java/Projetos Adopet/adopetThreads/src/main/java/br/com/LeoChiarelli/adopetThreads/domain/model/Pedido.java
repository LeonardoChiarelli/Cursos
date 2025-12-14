package br.com.LeoChiarelli.adopetThreads.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Pedido")
@Table(name = "pedidos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate data;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pedido")
    private List<ItemPedido> itens = new ArrayList<>();

    @ManyToOne
    private Usuario usuario;

    public Pedido(List<ItemPedido> itens, Usuario usuario) {
        this.data = LocalDate.now();
        this.itens = itens;
        this.itens.forEach(i -> i.setPedido(this));
        this.usuario = usuario;
    }

}

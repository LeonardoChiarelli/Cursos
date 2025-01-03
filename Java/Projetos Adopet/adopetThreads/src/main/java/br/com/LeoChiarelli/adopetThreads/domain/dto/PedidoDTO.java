package br.com.LeoChiarelli.adopetThreads.domain.dto;

import br.com.LeoChiarelli.adopetThreads.domain.model.Pedido;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public record PedidoDTO(Long id, LocalDate data, List<ItemPedidoDTO> itens) {
    public PedidoDTO(Pedido pedido) {
        this(pedido.getId(), pedido.getData(), pedido.getItens().stream().map(ItemPedidoDTO::new).collect(Collectors.toList()));
    }
}

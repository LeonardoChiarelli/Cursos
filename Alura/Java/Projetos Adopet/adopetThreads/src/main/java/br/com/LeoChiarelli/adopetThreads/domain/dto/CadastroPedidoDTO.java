package br.com.LeoChiarelli.adopetThreads.domain.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record CadastroPedidoDTO(@NotNull @Valid List<ItemPedidoDTO> itens) {
}

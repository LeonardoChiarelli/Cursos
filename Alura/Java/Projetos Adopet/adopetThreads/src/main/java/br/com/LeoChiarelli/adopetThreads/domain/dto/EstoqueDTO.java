package br.com.LeoChiarelli.adopetThreads.domain.dto;

import br.com.LeoChiarelli.adopetThreads.domain.model.Estoque;

public record EstoqueDTO(Long produtoId, Integer quantidade) {

    public EstoqueDTO(Estoque estoque){
        this(estoque.getProduto().getId(), estoque.getQuantidade());
    }
}

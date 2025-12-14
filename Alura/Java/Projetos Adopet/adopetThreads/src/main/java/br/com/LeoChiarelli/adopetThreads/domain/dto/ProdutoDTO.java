package br.com.LeoChiarelli.adopetThreads.domain.dto;

import br.com.LeoChiarelli.adopetThreads.domain.model.Produto;

import java.math.BigDecimal;

public record ProdutoDTO(Long id, String nome, String descricao, BigDecimal preco) {
    public ProdutoDTO(Produto produto){
        this(produto.getId(), produto.getNome(), produto.getDescricao(), produto.getPreco());
    }
}
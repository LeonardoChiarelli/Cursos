package br.com.LeoChiarelli.adopetThreads.domain.dto;

import br.com.LeoChiarelli.adopetThreads.domain.model.Categoria;

import java.math.BigDecimal;

public record EstatisticasVenda(Categoria categoria, Long quantidadesVenda, BigDecimal faturamento) {
}

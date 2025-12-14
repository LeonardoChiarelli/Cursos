package br.com.LeoChiarelli.adopetThreads.domain.service;

import br.com.LeoChiarelli.adopetThreads.domain.dto.ProdutoDTO;
import br.com.LeoChiarelli.adopetThreads.domain.dto.RelatorioEstoque;
import br.com.LeoChiarelli.adopetThreads.domain.dto.RelatorioFaturamento;
import br.com.LeoChiarelli.adopetThreads.domain.repository.IEstoqueRepository;
import br.com.LeoChiarelli.adopetThreads.domain.repository.IPedidoRepository;
import br.com.LeoChiarelli.adopetThreads.domain.repository.IProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
public class RelatorioService {
    @Autowired
    private IProdutoRepository produtoRepository;

    @Autowired
    private IEstoqueRepository estoqueRepository;

    @Autowired
    private IPedidoRepository pedidoRepository;

    @Async
    public CompletableFuture<RelatorioEstoque> infoEstoque(){
        var produtosSemEstoque = estoqueRepository.produtosComEstoqueZerado()
                .stream().map(ProdutoDTO::new)
                .collect(Collectors.toList());
        return CompletableFuture.completedFuture(new RelatorioEstoque(produtosSemEstoque));
    }

    @Async
    public CompletableFuture<RelatorioFaturamento> faturamentoObtido() {
        var dataOntem = LocalDate.now().minusDays(1);
        var faturamentoTotal = pedidoRepository.faturamentoTotalDoDia(dataOntem);

        var estatisticas = pedidoRepository.faturamentoTotalDoDiaPorCategoria(dataOntem);

        return CompletableFuture.completedFuture(new RelatorioFaturamento(faturamentoTotal, estatisticas));
    }
}
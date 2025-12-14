package br.com.LeoChiarelli.adopetThreads.domain.repository;

import br.com.LeoChiarelli.adopetThreads.domain.model.Estoque;
import br.com.LeoChiarelli.adopetThreads.domain.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IEstoqueRepository extends JpaRepository<Estoque, Long> {

    Estoque findByProdutoId(Long idProduto);

    @Query("SELECT e FROM Estoque e WHERE e.produto.ativo=true")
    List<Estoque> findAll();

    @Query("SELECT e.produto FROM Estoque e WHERE e.quantidade = 0")
    List<Produto> produtosComEstoqueZerado();
}

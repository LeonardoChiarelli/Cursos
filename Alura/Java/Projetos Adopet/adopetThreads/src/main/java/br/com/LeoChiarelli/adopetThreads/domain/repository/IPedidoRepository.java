package br.com.LeoChiarelli.adopetThreads.domain.repository;

import br.com.LeoChiarelli.adopetThreads.domain.dto.EstatisticasVenda;
import br.com.LeoChiarelli.adopetThreads.domain.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface IPedidoRepository extends JpaRepository<Pedido, Long> {

    List<Pedido> findPedidoByData(LocalDate now);

    @Query("""
            SELECT SUM(i.precoUnitario * i.quantidade)
            FROM Pedido p
            JOIN p.itens i
            WHERE p.data = :data
            """)
    BigDecimal faturamentoTotalDoDia(LocalDate data);

    @Query("""
        SELECT NEW br.com.LeoChiarelli.adopetThreads.domain.dto.EstatisticasVenda(
            prod.categoria,
            SUM(i.quantidade),
            SUM(i.precoUnitario * i.quantidade)
        )
        FROM Pedido p
        JOIN p.itens i
        JOIN i.produto prod
        WHERE p.data = :data
        GROUP BY prod.categoria
        """)
    List<EstatisticasVenda> faturamentoTotalDoDiaPorCategoria(LocalDate data);

}

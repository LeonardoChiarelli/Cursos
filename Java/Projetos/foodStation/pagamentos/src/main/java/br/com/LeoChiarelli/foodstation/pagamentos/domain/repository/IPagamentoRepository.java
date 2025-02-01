package br.com.LeoChiarelli.foodstation.pagamentos.domain.repository;

import br.com.LeoChiarelli.foodstation.pagamentos.domain.model.Pagamento;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface IPagamentoRepository extends JpaRepository<Pagamento, Long> {

    boolean existsByPedidoId(@NotNull Long idPedido);

    @Modifying
    @Query("DELETE FROM Pagamento p WHERE p.status = 'CANCELADO'")
    void deleteAllByStatusCancelado();
}

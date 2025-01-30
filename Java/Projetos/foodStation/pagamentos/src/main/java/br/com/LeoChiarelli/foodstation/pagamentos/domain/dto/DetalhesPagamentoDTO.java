package br.com.LeoChiarelli.foodstation.pagamentos.domain.dto;

import br.com.LeoChiarelli.foodstation.pagamentos.domain.model.Pagamento;
import br.com.LeoChiarelli.foodstation.pagamentos.domain.model.Status;

public record DetalhesPagamentoDTO(
        Long id,
        Long idPedido,
        Status status
) {
    public DetalhesPagamentoDTO(Pagamento pagamento){
        this(pagamento.getId(), pagamento.getPedidoId(), pagamento.getStatus());
    }
}

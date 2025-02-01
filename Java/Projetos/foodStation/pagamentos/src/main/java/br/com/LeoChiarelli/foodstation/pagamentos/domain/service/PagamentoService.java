package br.com.LeoChiarelli.foodstation.pagamentos.domain.service;

import br.com.LeoChiarelli.foodstation.pagamentos.domain.dto.AtualizarStatusPagamentoDTO;
import br.com.LeoChiarelli.foodstation.pagamentos.domain.dto.CadastrarPagamentoDTO;
import br.com.LeoChiarelli.foodstation.pagamentos.domain.dto.DetalhesPagamentoDTO;
import br.com.LeoChiarelli.foodstation.pagamentos.domain.model.Pagamento;
import br.com.LeoChiarelli.foodstation.pagamentos.domain.repository.IPagamentoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PagamentoService {

    @Autowired
    private IPagamentoRepository repository;

    public DetalhesPagamentoDTO cadastrarPagamento(CadastrarPagamentoDTO dto){

        boolean jaCadastrado = repository.existsByPedidoId(dto.idPedido());
        if (jaCadastrado) { throw new RuntimeException("Pedido já cadastrado"); }

        var pagamento = new Pagamento(dto);
        repository.save(pagamento);
        return new DetalhesPagamentoDTO(pagamento);
    }

    public Page<DetalhesPagamentoDTO> listarPagamentos(Pageable pageable){
        return repository.findAll(pageable).map(DetalhesPagamentoDTO::new);
    }

    public DetalhesPagamentoDTO obterDetalhes(Long id) {
        return repository.findById(id).map(DetalhesPagamentoDTO::new).orElseThrow(() -> new RuntimeException("Pagamento não encontrado"));
    }

    public DetalhesPagamentoDTO atualizar(Long id) {
        var pagamento = repository.getReferenceById(id);
        pagamento.atualizarStatus();
        repository.save(pagamento);

        return new DetalhesPagamentoDTO(pagamento);
    }

    public void cancelarPagamento(Long id) {
        var pagamento = repository.getReferenceById(id);
        pagamento.cancelar();
        repository.save(pagamento);
    }

    public void deletar() {
        repository.deleteAllByStatusCancelado();
    }
}

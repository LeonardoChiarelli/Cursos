package br.com.LeoChiarelli.foodstation.pagamentos.domain.controller;

import br.com.LeoChiarelli.foodstation.pagamentos.domain.dto.AtualizarStatusPagamentoDTO;
import br.com.LeoChiarelli.foodstation.pagamentos.domain.dto.CadastrarPagamentoDTO;
import br.com.LeoChiarelli.foodstation.pagamentos.domain.dto.DetalhesPagamentoDTO;
import br.com.LeoChiarelli.foodstation.pagamentos.domain.service.PagamentoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {

    @Autowired
    private PagamentoService service;

    @PostMapping
    @Transactional
    public ResponseEntity<DetalhesPagamentoDTO> cadastrarPagamento(@RequestBody @Valid CadastrarPagamentoDTO dto, UriComponentsBuilder uriBuilder){
        var pagamento = service.cadastrarPagamento(dto);

        var uri = uriBuilder.path("/{id}").buildAndExpand(dto.id()).toUri();

        return ResponseEntity.created(uri).body(pagamento);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DetalhesPagamentoDTO> atualizarStatus(@RequestBody @Valid AtualizarStatusPagamentoDTO dto){
        var pagamento = service.atualizar(dto);

        return ResponseEntity.ok(pagamento);
    }

    @GetMapping
    public ResponseEntity<Page<DetalhesPagamentoDTO>> listarPagamentos(Pageable pageable){
        var page = service.listarPagamentos(pageable);

        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalhesPagamentoDTO> obterDetalhes(@PathVariable Long id){
        var pagamento = service.obterDetalhes(id);

        return ResponseEntity.ok(pagamento);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> cancelarPagamento(@PathVariable Long id){
        service.cancelarPagamento(id);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity<?> deletarPagamentosCancelados(){
        service.deletar();
        return ResponseEntity.noContent().build();
    }

}

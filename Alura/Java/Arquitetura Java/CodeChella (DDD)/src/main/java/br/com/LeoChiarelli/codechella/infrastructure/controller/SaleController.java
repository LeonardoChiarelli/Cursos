package br.com.LeoChiarelli.codechella.infrastructure.controller;

import br.com.LeoChiarelli.codechella.infrastructure.gatewaysArrumar.SaleService;
import br.com.LeoChiarelli.codechella.infrastructure.dto.RegistrySaleDTO;
import br.com.LeoChiarelli.codechella.infrastructure.dto.SaleDataDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/sales")
public class SaleController {

    @Autowired
    private SaleService service;

    @PostMapping
    @Transactional
    public ResponseEntity<SaleDataDTO> cadastrar(@RequestBody @Valid RegistrySaleDTO dadosVenda, UriComponentsBuilder uriBuilder) {
        SaleDataDTO venda = service.registrySale(dadosVenda);
        var uri = uriBuilder.path("/vendas/{id}").buildAndExpand(venda.id()).toUri();

        return ResponseEntity.created(uri).body(venda);
    }

    @GetMapping
    public ResponseEntity<List<SaleDataDTO>> listar() {
        return ResponseEntity.ok(service.listAll());
    }

}

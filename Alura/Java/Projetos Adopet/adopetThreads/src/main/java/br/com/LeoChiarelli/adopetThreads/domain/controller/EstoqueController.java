package br.com.LeoChiarelli.adopetThreads.domain.controller;

import br.com.LeoChiarelli.adopetThreads.domain.dto.AtualizaEstoqueDTO;
import br.com.LeoChiarelli.adopetThreads.domain.dto.EstoqueDTO;
import br.com.LeoChiarelli.adopetThreads.domain.service.EstoqueService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("admin/estoques")
public class EstoqueController {

    @Autowired
    private EstoqueService service;

    @GetMapping
    public ResponseEntity<List<EstoqueDTO>> listar() {
        var estoques = service.listar();
        return ResponseEntity.ok(estoques);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<Void> atualizar(@RequestBody @Valid AtualizaEstoqueDTO dto) {
        service.atualizarEstoque(dto);
        return ResponseEntity.ok().build();
    }
}

package br.com.LeoChiarelli.adopetThreads.domain.controller;

import br.com.LeoChiarelli.adopetThreads.domain.dto.RelatorioEstoque;
import br.com.LeoChiarelli.adopetThreads.domain.dto.RelatorioFaturamento;
import br.com.LeoChiarelli.adopetThreads.domain.service.RelatorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin/relatorios")
public class RelatorioController {
    @Autowired
    private RelatorioService service;

    @GetMapping("estoque")
    public ResponseEntity<RelatorioEstoque> obterInfoEstoque(){
        var relatorio = service.infoEstoque();
        return ResponseEntity.ok(relatorio);
    }

    @GetMapping("faturamento")
    public ResponseEntity<RelatorioFaturamento> obterInfoFaturamento(){
        var relatorio = service.faturamentoObtido();
        return ResponseEntity.ok(relatorio);
    }
}

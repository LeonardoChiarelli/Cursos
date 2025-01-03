package br.com.LeoChiarelli.adopetThreads.domain.controller;

import br.com.LeoChiarelli.adopetThreads.domain.dto.CadastroPedidoDTO;
import br.com.LeoChiarelli.adopetThreads.domain.dto.PedidoDTO;
import br.com.LeoChiarelli.adopetThreads.domain.email.EmailPedidoRealizado;
import br.com.LeoChiarelli.adopetThreads.domain.model.Usuario;
import br.com.LeoChiarelli.adopetThreads.domain.service.PedidoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pedidos")
public class PedidoController {

    @Autowired
    private PedidoService service;

    @Autowired
    private EmailPedidoRealizado email;

    @PostMapping
    public ResponseEntity<PedidoDTO> cadastrar(@Valid @RequestBody CadastroPedidoDTO dto, @AuthenticationPrincipal Usuario usuario) {
        var pedido = this.service.cadastrar(dto, usuario);
        email.enviar(pedido, usuario);
        return ResponseEntity.ok(pedido);
    }
}

package br.com.LeoChiarelli.adopetThreads.domain.email;

import br.com.LeoChiarelli.adopetThreads.domain.dto.PedidoDTO;
import br.com.LeoChiarelli.adopetThreads.domain.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class EmailPedidoRealizado {

    @Autowired
    private EnviadorEmail enviador;

    @Async // Para criar um thread separada
    public void enviar(PedidoDTO dto, Usuario usuario){
        enviador.enviarEmail(
                "Pedido efetuado com sucesso na Adopet Store",
                usuario.getEmail(),
                "Olá! " + "!\n\nSeu pedido foi registrado. Itens: \n" + dto.itens());
    }
}

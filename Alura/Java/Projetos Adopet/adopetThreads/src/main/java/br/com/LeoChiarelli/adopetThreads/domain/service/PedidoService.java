package br.com.LeoChiarelli.adopetThreads.domain.service;

import br.com.LeoChiarelli.adopetThreads.domain.dto.CadastroPedidoDTO;
import br.com.LeoChiarelli.adopetThreads.domain.dto.PedidoDTO;
import br.com.LeoChiarelli.adopetThreads.domain.model.ItemPedido;
import br.com.LeoChiarelli.adopetThreads.domain.model.Pedido;
import br.com.LeoChiarelli.adopetThreads.domain.model.Usuario;
import br.com.LeoChiarelli.adopetThreads.domain.repository.IEstoqueRepository;
import br.com.LeoChiarelli.adopetThreads.domain.repository.IPedidoRepository;
import br.com.LeoChiarelli.adopetThreads.domain.repository.IProdutoRepository;
import br.com.LeoChiarelli.adopetThreads.general.exception.ValidacaoException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PedidoService {

    @Autowired
    private IPedidoRepository repository;

    @Autowired
    private IProdutoRepository produtoRepository;

    @Autowired
    private IEstoqueRepository estoqueRepository;

    @Transactional
    public PedidoDTO cadastrar(CadastroPedidoDTO dto, Usuario usuario) {
        var itens = new ArrayList<ItemPedido>();
        for (var itemDto : dto.itens()) {
            var estoque = estoqueRepository.findByProdutoId(itemDto.produtoId());
            if (estoque.getQuantidade() >= itemDto.quantidade()) {
                var produto = produtoRepository.findById(itemDto.produtoId()).get();
                if (!produto.getAtivo())
                    throw new ValidacaoException("Pedido contém produto excluído: " + produto.getId());
                var itemPedido = new ItemPedido(null, produto, itemDto.quantidade());
                itens.add(itemPedido);
                estoque.diminuir(itemDto.quantidade());
            } else {
                throw new ValidacaoException("Estoque indisponível para o produto: " + itemDto.produtoId());
            }
        }

        var pedido = new Pedido(itens, usuario);
        repository.save(pedido);

        return new PedidoDTO(pedido);

    }
}

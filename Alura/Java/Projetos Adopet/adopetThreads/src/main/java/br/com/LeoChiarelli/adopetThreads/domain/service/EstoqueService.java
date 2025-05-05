package br.com.LeoChiarelli.adopetThreads.domain.service;

import br.com.LeoChiarelli.adopetThreads.domain.dto.AtualizaEstoqueDTO;
import br.com.LeoChiarelli.adopetThreads.domain.dto.EstoqueDTO;
import br.com.LeoChiarelli.adopetThreads.domain.repository.IEstoqueRepository;
import br.com.LeoChiarelli.adopetThreads.general.exception.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstoqueService {

    @Autowired
    private IEstoqueRepository repository;

    public List<EstoqueDTO> listar(){
        return repository.findAll()
                .stream().map(EstoqueDTO::new).collect(Collectors.toList());
    }

    public void atualizarEstoque(AtualizaEstoqueDTO dto){
        var estoque = repository.findByProdutoId(dto.idProduto());
        if(!estoque.getProduto().getAtivo())
            throw new ValidacaoException("Produto excluído!");
        estoque.adicionar(dto.quantidade());
    }
}

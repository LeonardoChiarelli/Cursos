package br.com.LeoChiarelli.adopetThreads.domain.service;

import br.com.LeoChiarelli.adopetThreads.domain.dto.CadastroProdutoDTO;
import br.com.LeoChiarelli.adopetThreads.domain.dto.ProdutoDTO;
import br.com.LeoChiarelli.adopetThreads.domain.model.Estoque;
import br.com.LeoChiarelli.adopetThreads.domain.model.Produto;
import br.com.LeoChiarelli.adopetThreads.domain.repository.IEstoqueRepository;
import br.com.LeoChiarelli.adopetThreads.domain.repository.IProdutoRepository;
import br.com.LeoChiarelli.adopetThreads.general.exception.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {
    @Autowired
    private IProdutoRepository repository;

    @Autowired
    private IEstoqueRepository estoqueRepository;

    public ProdutoDTO cadastrar(CadastroProdutoDTO dto){
        var jaCadastrado = repository.existsByNomeIgnoringCase(dto.nome());
        if(jaCadastrado)
            throw new ValidacaoException("Produto já cadastrado!");

        var produto = new Produto(dto);
        repository.save(produto);

        var estoque = new Estoque(dto.estoqueInicial(), produto);
        estoqueRepository.save(estoque);
        return new ProdutoDTO(produto);
    }

    public Page<ProdutoDTO> listar(Pageable paginacao){
        return repository.findAll(paginacao).map(ProdutoDTO::new);
    }

    public void excluir(Long idProduto){
        var produto = repository.findById(idProduto).get();
        produto.desativar();
    }
}

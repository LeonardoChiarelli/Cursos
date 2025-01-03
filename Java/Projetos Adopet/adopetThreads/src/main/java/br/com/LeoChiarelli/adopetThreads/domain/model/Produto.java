package br.com.LeoChiarelli.adopetThreads.domain.model;

import br.com.LeoChiarelli.adopetThreads.domain.dto.CadastroProdutoDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity(name = "Produto")
@Table(name="produtos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    private BigDecimal preco;
    private Boolean ativo;

    public Produto(CadastroProdutoDTO dto){
        this.nome = dto.nome();
        this.descricao = dto.descricao();
        this.categoria = Categoria.valueOf(dto.categoria().toUpperCase());
        this.preco = dto.preco();
        this.ativo = true;
    }

    public void desativar(){
        this.ativo = false;
    }
    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", preco=" + preco +
                '}';
    }
}
package br.com.LeoChiarelli.adopet.api.domain.model;

import br.com.LeoChiarelli.adopet.api.domain.dto.CadastrarPetDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Pet")
@Table(name = "pets")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TipoPet tipo;

    private String nome;
    private String raca;
    private Integer idade;
    private String cor;
    private Float peso;
    private Boolean adotado;

    @ManyToOne
    private Abrigo abrigo;

    @OneToOne(mappedBy = "pet", fetch = FetchType.LAZY)
    private Adocao adocao;

    public Pet(CadastrarPetDTO dto, Abrigo abrigo) {
        this.tipo = dto.tipoPet();
        this.nome = dto.nome();
        this.raca = dto.raca();
        this.idade = dto.idade();
        this.cor = dto.cor();
        this.peso = dto.peso();
        this.adotado = false;
        this.abrigo = abrigo;
    }

    public Pet(){}

    public Long getId() {
        return id;
    }

    public TipoPet getTipo() {
        return tipo;
    }

    public String getNome() {
        return nome;
    }

    public String getRaca() {
        return raca;
    }

    public Integer getIdade() {
        return idade;
    }

    public String getCor() {
        return cor;
    }

    public Boolean getAdotado() {
        return adotado;
    }

    public Abrigo getAbrigo() {
        return abrigo;
    }

    public Float getPeso() { return peso;}
}

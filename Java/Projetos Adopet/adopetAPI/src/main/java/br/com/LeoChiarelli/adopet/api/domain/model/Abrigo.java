package br.com.LeoChiarelli.adopet.api.domain.model;

import br.com.LeoChiarelli.adopet.api.domain.dto.CadastrarAbrigoDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import java.util.List;

@Entity(name = "Abrigo")
@Table(name = "abrigos")
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Abrigo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String telefone;
    private String email;

    @OneToMany(mappedBy = "abrigo", cascade = CascadeType.ALL)
    private List<Pet> pets;

    public Abrigo(CadastrarAbrigoDTO dto) {
        this.nome = dto.nome();
        this.telefone = dto.telefone();
        this.email = dto.email();
    }

    public Abrigo(){}

    public Abrigo(long id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public List<Pet> getPets() {
        return pets;
    }
}

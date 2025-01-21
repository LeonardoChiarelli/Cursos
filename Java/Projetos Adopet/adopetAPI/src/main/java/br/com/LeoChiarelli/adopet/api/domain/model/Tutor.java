package br.com.LeoChiarelli.adopet.api.domain.model;

import br.com.LeoChiarelli.adopet.api.domain.dto.AtualizarTutorDTO;
import br.com.LeoChiarelli.adopet.api.domain.dto.CadastrarTutorDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.Objects;

@Entity(name = "Tutor")
@Table(name = "tutores")
@AllArgsConstructor
public class Tutor {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    private String nome;
    @Getter
    private String telefone;
    @Getter
    private String email;

    @OneToMany(mappedBy = "tutor")
    private List<Adocao> adocoes;

    public Tutor(CadastrarTutorDTO dto) {
        this.nome = dto.nome();
        this.telefone = dto.telefone();
        this.email = dto.email();
    }

    public Tutor(){}

    public Tutor(long id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tutor tutor = (Tutor) o;
        return Objects.equals(id, tutor.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
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

    public void atualizarDados(AtualizarTutorDTO dto) {
        this.nome = dto.nome();
        this.telefone = dto.telefone();
        this.email = dto.email();
    }
}

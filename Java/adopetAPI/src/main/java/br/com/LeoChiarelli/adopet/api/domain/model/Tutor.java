package br.com.LeoChiarelli.adopet.api.domain.model;

import br.com.LeoChiarelli.adopet.api.domain.dto.AtualizarTutorDTO;
import br.com.LeoChiarelli.adopet.api.domain.dto.CadastrarTutorDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "Tutor")
@Table(name = "tutores")
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
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

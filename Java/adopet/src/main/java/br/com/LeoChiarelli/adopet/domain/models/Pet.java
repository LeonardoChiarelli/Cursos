package br.com.LeoChiarelli.adopet.domain.models;

import br.com.LeoChiarelli.adopet.domain.dto.PetDTO;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Pet")
@Table(name = "pets")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo;
    private String nome;
    private String raca;
    private String idade;
    private String cor;
    private String peso;

    @ManyToOne
    @JoinColumn(name = "abrigo_id", nullable = false)
    private Abrigo abrigo;

    public Pet(@NotNull @Valid PetDTO pet) {
        this.id = null;
        this.tipo = pet.tipo();
        this.nome = pet.nome();
        this.raca = pet.raca();
        this.idade = pet.idade();
        this.cor = pet.cor();
        this.peso = pet.peso();
    }
}

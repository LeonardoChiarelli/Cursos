package br.com.LeoChiarelli.adopet.domain.models;


import br.com.LeoChiarelli.adopet.domain.dto.AbrigoDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Abrigo")
@Table(name = "abrigos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Abrigo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String telefone;
    private String email;

    @OneToMany(mappedBy = "abrigo", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Pet pet;

    public Abrigo(AbrigoDTO data){
        this.id = null;
        this.nome = data.nome();
        this.telefone = data.telefone();
        this.email = data.email();

        this.pet = new Pet(data.pet());
    }
}

package br.com.LeoChiarelli.api.domain.doctor.models;

import br.com.LeoChiarelli.api.domain.doctor.dto.DoctorDTO;
import br.com.LeoChiarelli.api.domain.doctor.dto.UpdateDoctorDTO;
import br.com.LeoChiarelli.api.domain.address.models.Address;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Medico")
@Table(name = "medicos")
@Getter // Gerando getters atraves do 'lombock'
@NoArgsConstructor // Construtor padrão
@AllArgsConstructor // Construtor com todos os argumentos
@EqualsAndHashCode(of = "id")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email")
    private String email;

    @Column(name = "telefone")
    private String telefone;

    @Column (name = "crm")
    private String crm;

    @Enumerated(EnumType.STRING)
    @Column(name = "especialidade")
    private Specialty specialty;

    @Embedded
    @Column(name = "endereco")
    private Address address;

    private boolean ativo;


    public Doctor(DoctorDTO data) {
        this.ativo = true;
        this.id = null;
        this.nome = data.nome();
        this.email = data.email();
        this.telefone = data.telefone();
        this.crm = data.crm();
        this.specialty = data.especialidade();
        this.address = new Address(data.endereco());
    }

    public void updateInfo(@Valid UpdateDoctorDTO data) {
        if(data.nome() != null){
            this.nome = data.nome();
        }
        if (data.telefone() != null){
            this.telefone = data.telefone();
        }
        if (data.endereco() != null){
            this.address.updateInfo(data.endereco());
        }
    }

    public void deactivate() {
        this.ativo = false;
    }
}

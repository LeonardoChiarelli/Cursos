package br.com.LeoChiarelli.api.doctor.models;

import br.com.LeoChiarelli.api.doctor.dto.DoctorDTO;
import br.com.LeoChiarelli.api.general.models.Address;
import jakarta.persistence.*;
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
    private String name;

    @Column(name = "email")
    private String email;

    @Column (name = "crm")
    private String crm;

    @Enumerated(EnumType.STRING)
    @Column(name = "especialidade")
    private Specialty specialty;

    @Embedded
    @Column(name = "endereco")
    private Address address;


    public Doctor(DoctorDTO data) {
        this.id = null;
        this.name = data.nome();
        this.email = data.email();
        this.crm = data.crm();
        this.specialty = data.especialidade();
        this.address = new Address(data.endereco());
    }
}

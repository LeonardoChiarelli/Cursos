package br.com.LeoChiarelli.api.domain.models;

import br.com.LeoChiarelli.api.domain.dto.PatientDTO;
import br.com.LeoChiarelli.api.domain.dto.UpdatePatientDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "Paciente")
@Table(name = "pacientes")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;

    @Embedded
    private Address endereco;
    private boolean ativo;

    @Transient // pois não esta sendo salvo
    private List<Appointment> consultas;

    public Patient(PatientDTO data){
        this.ativo = true;
        this.nome = data.nome();
        this.email = data.email();
        this.telefone = data.telefone();
        this.cpf = data.cpf();
        this.endereco = new Address(data.endereco());
    }

    public void updateInfo(UpdatePatientDTO data){
        if(data.nome() != null){
            this.nome = data.nome();
        }
        if(data.telefone() != null){
            this.telefone = data.telefone();
        }
        if(data.endereco() != null){
            this.endereco.updateInfo(data.endereco());
        }
    }

    public void delete(){
        this.ativo = false;
    }

    public List<Appointment> consultas() { return consultas; }
}

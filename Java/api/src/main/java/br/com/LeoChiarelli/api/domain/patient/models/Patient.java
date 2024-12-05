package br.com.LeoChiarelli.api.domain.patient.models;

import br.com.LeoChiarelli.api.domain.address.models.Address;
import br.com.LeoChiarelli.api.domain.patient.dto.PatientDTO;
import br.com.LeoChiarelli.api.domain.patient.dto.UpdatePatientDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
}

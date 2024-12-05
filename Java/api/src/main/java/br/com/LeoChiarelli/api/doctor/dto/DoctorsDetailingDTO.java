package br.com.LeoChiarelli.api.doctor.dto;

import br.com.LeoChiarelli.api.doctor.models.Doctor;
import br.com.LeoChiarelli.api.doctor.models.Specialty;
import br.com.LeoChiarelli.api.general.models.Address;

public record DoctorsDetailingDTO(Long id, String nome, String email, String crm, String telefone, Specialty especialidade, Address endereco) {

    public DoctorsDetailingDTO(Doctor medico){
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getTelefone(), medico.getSpecialty(), medico.getAddress());
    }
}

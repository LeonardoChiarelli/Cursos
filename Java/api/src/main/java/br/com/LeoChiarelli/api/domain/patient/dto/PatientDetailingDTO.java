package br.com.LeoChiarelli.api.domain.patient.dto;

import br.com.LeoChiarelli.api.domain.address.models.Address;
import br.com.LeoChiarelli.api.domain.patient.models.Patient;

public record PatientDetailingDTO(Long id, String nome, String email, String telefone, String cpf, Address endereco) {

    public PatientDetailingDTO(Patient paciente){
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getTelefone(), paciente.getCpf(), paciente.getEndereco());
    }
}

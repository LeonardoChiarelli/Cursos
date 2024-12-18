package br.com.LeoChiarelli.api.domain.dto;

import br.com.LeoChiarelli.api.domain.models.Address;
import br.com.LeoChiarelli.api.domain.models.Patient;

public record PatientDetailingDTO(Long id, String nome, String email, String telefone, String cpf, Address endereco) {

    public PatientDetailingDTO(Patient paciente){
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getTelefone(), paciente.getCpf(), paciente.getEndereco());
    }
}

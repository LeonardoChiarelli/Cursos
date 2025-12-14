package br.com.LeoChiarelli.api.domain.dto;

import br.com.LeoChiarelli.api.domain.models.Patient;

public record ListPatientDTO(Long id, String nome, String email, String cpf) {

    public ListPatientDTO(Patient patient){
        this(patient.getId(), patient.getNome(), patient.getEmail(), patient.getCpf());
    }

}

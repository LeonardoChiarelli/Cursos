package br.com.LeoChiarelli.api.domain.patient.dto;

import br.com.LeoChiarelli.api.domain.patient.models.Patient;

public record ListPatientDTO(Long id, String nome, String email, String cpf) {

    public ListPatientDTO(Patient patient){
        this(patient.getId(), patient.getNome(), patient.getEmail(), patient.getCpf());
    }

}

package br.com.LeoChiarelli.api.domain.dto;

import br.com.LeoChiarelli.api.domain.models.Doctor;
import br.com.LeoChiarelli.api.domain.models.Specialty;

public record ListDoctorDTO(
        Long id,
        String nome,
        String email,
        String crm,
        Specialty especialidade
) {
    public ListDoctorDTO(Doctor doctor){
        this(doctor.getId(), doctor.getNome(), doctor.getEmail(), doctor.getCrm(), doctor.getSpecialty());
    }
}

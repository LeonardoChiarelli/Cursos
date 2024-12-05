package br.com.LeoChiarelli.api.doctor.dto;

import br.com.LeoChiarelli.api.doctor.models.Doctor;
import br.com.LeoChiarelli.api.doctor.models.Specialty;

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

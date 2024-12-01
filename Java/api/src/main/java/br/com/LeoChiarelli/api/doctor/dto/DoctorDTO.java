package br.com.LeoChiarelli.api.doctor.dto;

import br.com.LeoChiarelli.api.general.dto.AddressDTO;
import br.com.LeoChiarelli.api.doctor.models.Specialty;

public record DoctorDTO(
        Long id,
        String nome,
        String email,
        String crm,
        Specialty especialidade,
        AddressDTO endereco){
}

package br.com.LeoChiarelli.api.domain.appointment.validation;

import br.com.LeoChiarelli.api.domain.appointment.dto.AppointmentDTO;
import br.com.LeoChiarelli.api.domain.patient.repository.IPatientRepository;
import jakarta.validation.ValidationException;

public class IsPatientActive {

    private IPatientRepository repository;

    public void validate(AppointmentDTO data){
        var isPatientActive = repository.findAtivoById(data.idPaciente());

        if(!isPatientActive){
            throw new ValidationException("Consulta não pode ser agendada com paciente inativo");
        }
    }
}

package br.com.LeoChiarelli.api.domain.appointment.validation;

import br.com.LeoChiarelli.api.domain.appointment.dto.AppointmentDTO;
import br.com.LeoChiarelli.api.domain.patient.repository.IPatientRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IsPatientActive implements IValidation{

    @Autowired
    private IPatientRepository repository;

    public void validate(AppointmentDTO data){
        var isPatientActive = repository.existsById(data.idPaciente());

        if(!isPatientActive){
            throw new ValidationException("Consulta não pode ser agendada com paciente inativo");
        }
    }
}

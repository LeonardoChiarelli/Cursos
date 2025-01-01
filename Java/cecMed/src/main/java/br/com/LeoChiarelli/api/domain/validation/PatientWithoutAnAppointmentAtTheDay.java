package br.com.LeoChiarelli.api.domain.validation;

import br.com.LeoChiarelli.api.domain.dto.AppointmentDTO;
import br.com.LeoChiarelli.api.domain.repository.IAppointmentRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PatientWithoutAnAppointmentAtTheDay implements IValidation{

    @Autowired
    private IAppointmentRepository repository;

    public void validate(AppointmentDTO data){
        var primeiroHorario = data.data().withHour(7);
        var ultimoHorario = data.data().withHour(19);
        var patientHasAnAppointmentAtTheDay = repository.existsByPacienteIdAndDataBetween(data.idPaciente(), primeiroHorario, ultimoHorario);

        if(patientHasAnAppointmentAtTheDay){
            throw new ValidationException("Paciente já possui uma consulta neste dia");
        }
    }
}

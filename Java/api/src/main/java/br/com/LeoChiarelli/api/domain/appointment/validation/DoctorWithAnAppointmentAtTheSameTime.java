package br.com.LeoChiarelli.api.domain.appointment.validation;

import br.com.LeoChiarelli.api.domain.appointment.dto.AppointmentDTO;
import br.com.LeoChiarelli.api.domain.appointment.repository.IAppointmentRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DoctorWithAnAppointmentAtTheSameTime implements IValidation{

    @Autowired
    private IAppointmentRepository repository;

    public void validate(AppointmentDTO data){
        var doctorHasAnAppointmentAtTheSameTime = repository.existsByIdAndData(data.idMedico(), data.data());

        if(doctorHasAnAppointmentAtTheSameTime){
            throw new ValidationException("Médico já possui outra consulta agendada neste horário");
        }
    }
}

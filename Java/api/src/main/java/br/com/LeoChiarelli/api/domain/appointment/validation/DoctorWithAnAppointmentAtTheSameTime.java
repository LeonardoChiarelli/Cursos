package br.com.LeoChiarelli.api.domain.appointment.validation;

import br.com.LeoChiarelli.api.domain.appointment.dto.AppointmentDTO;
import br.com.LeoChiarelli.api.domain.doctor.repository.IDoctorRepository;
import jakarta.validation.ValidationException;

public class DoctorWithAnAppointmentAtTheSameTime {

    private IDoctorRepository repository;

    public void validate(AppointmentDTO data){
        var doctorHasAnAppointmentAtTheSameTime = repository.existsByMedicoIdAndData(data.idMedico(), data.data());

        if(doctorHasAnAppointmentAtTheSameTime){
            throw new ValidationException("Médico já possui outra consulta agendada neste horário");
        }
    }
}

package br.com.LeoChiarelli.api.domain.appointment.validation;

import br.com.LeoChiarelli.api.domain.appointment.dto.AppointmentDTO;
import br.com.LeoChiarelli.api.domain.doctor.repository.IDoctorRepository;
import jakarta.validation.ValidationException;

public class ActiveDoctor {

    private IDoctorRepository repository;

    public void validate(AppointmentDTO data){


        //escolha do médico opcional
        if(data.idMedico() == null){
            return;
        }

        var isActiveDoctor = repository.findAtivoById(data.idMedico());

        if(!isActiveDoctor){
            throw new ValidationException("Consulta não pode ser agendada com um médico inativo");
        }
    }
}

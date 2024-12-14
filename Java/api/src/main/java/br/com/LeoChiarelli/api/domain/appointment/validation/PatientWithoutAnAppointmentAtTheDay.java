package br.com.LeoChiarelli.api.domain.appointment.validation;

import br.com.LeoChiarelli.api.domain.appointment.dto.AppointmentDTO;
import br.com.LeoChiarelli.api.domain.appointment.repository.IAppointmentRepository;
import jakarta.validation.ValidationException;

public class PatientWithoutAnAppointmentAtTheDay {

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

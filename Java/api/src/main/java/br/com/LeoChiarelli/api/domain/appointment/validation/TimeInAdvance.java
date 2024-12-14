package br.com.LeoChiarelli.api.domain.appointment.validation;

import br.com.LeoChiarelli.api.domain.appointment.dto.AppointmentDTO;
import jakarta.validation.ValidationException;

import java.time.Duration;
import java.time.LocalDateTime;

public class TimeInAdvance {

    public void validate(AppointmentDTO data){
        var dataConsulta = data.data();
        var agora = LocalDateTime.now();
        var diferencaEmMinutos = Duration.between(agora, dataConsulta).toMinutes();

        if(diferencaEmMinutos < 30){
            throw new ValidationException("Consultas devem ser agendadas com no mínimo 30 minutos de antecedência");
        }
    }
}

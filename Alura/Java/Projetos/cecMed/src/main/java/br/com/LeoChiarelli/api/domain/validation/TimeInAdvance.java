package br.com.LeoChiarelli.api.domain.validation;

import br.com.LeoChiarelli.api.domain.dto.AppointmentDTO;
import jakarta.validation.ValidationException;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class TimeInAdvance implements IValidation{

    public void validate(AppointmentDTO data){
        var dataConsulta = data.data();
        var agora = LocalDateTime.now();
        var diferencaEmMinutos = Duration.between(agora, dataConsulta).toMinutes();

        if(diferencaEmMinutos < 30){
            throw new ValidationException("Consultas devem ser agendadas com no mínimo 30 minutos de antecedência");
        }
    }
}

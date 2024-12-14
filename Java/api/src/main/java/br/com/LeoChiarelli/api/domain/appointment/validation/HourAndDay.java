package br.com.LeoChiarelli.api.domain.appointment.validation;

import br.com.LeoChiarelli.api.domain.appointment.dto.AppointmentDTO;
import jakarta.validation.ValidationException;

import java.time.DayOfWeek;

public class HourAndDay {

    public void validate(AppointmentDTO data){
        var dataConsulta = data.data();

        var domingo = dataConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var antesDaAberturaDaClinica = dataConsulta.getHour() < 7;
        var depoisDoFechamentoDaClinica = dataConsulta.getHour() > 18;

        if(domingo || antesDaAberturaDaClinica || depoisDoFechamentoDaClinica){
            throw new ValidationException("Consulta fora do horário de funcionamento da clínica");
        }
    }

}

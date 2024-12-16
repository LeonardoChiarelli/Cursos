package br.com.LeoChiarelli.api.domain.appointment.validation;

import br.com.LeoChiarelli.api.domain.appointment.dto.AppointmentDTO;

public interface IValidation {

    void validate(AppointmentDTO data);
}

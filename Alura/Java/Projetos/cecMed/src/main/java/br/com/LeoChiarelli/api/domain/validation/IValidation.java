package br.com.LeoChiarelli.api.domain.validation;

import br.com.LeoChiarelli.api.domain.dto.AppointmentDTO;

public interface IValidation {

    void validate(AppointmentDTO data);
}

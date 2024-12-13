package br.com.LeoChiarelli.api.domain.appointment.repository;

import br.com.LeoChiarelli.api.domain.appointment.models.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppointmentRepository extends JpaRepository<Appointment, Long> {

}

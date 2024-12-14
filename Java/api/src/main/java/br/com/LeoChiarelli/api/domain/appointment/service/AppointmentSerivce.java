package br.com.LeoChiarelli.api.domain.appointment.service;

import br.com.LeoChiarelli.api.domain.appointment.dto.AppointmentCancelDTO;
import br.com.LeoChiarelli.api.domain.appointment.dto.AppointmentDTO;
import br.com.LeoChiarelli.api.domain.appointment.models.Appointment;
import br.com.LeoChiarelli.api.domain.appointment.repository.IAppointmentRepository;
import br.com.LeoChiarelli.api.domain.doctor.models.Doctor;
import br.com.LeoChiarelli.api.domain.doctor.repository.IDoctorRepository;
import br.com.LeoChiarelli.api.domain.patient.repository.IPatientRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentSerivce {

    @Autowired
    IAppointmentRepository repository;

    @Autowired
    IDoctorRepository doctorRepository;

    @Autowired
    IPatientRepository patientRepository;

    public void schedule(AppointmentDTO data){
        if(!patientRepository.existsById(data.idPaciente())){
            throw new ValidationException("Id do paciente informado, não existe!");
        }

        if(data.idMedico() != null && !doctorRepository.existsById(data.idMedico())){
            throw new ValidationException("Id do médico informado, não existe!");
        }

        var medico = chooseDoctor(data);
        var paciente = patientRepository.getReferenceById(data.idPaciente());

        var consulta = new Appointment(null, medico, paciente, data.data(), null);
        repository.save(consulta);
    }

    private Doctor chooseDoctor(AppointmentDTO data) {
        if(data.idMedico() != null){
            return doctorRepository.getReferenceById(data.idMedico());
        }

        if(data.especialidade() == null){
            throw new ValidationException("Especialidade é obrigatória quando o médico não for escolhido");
        }

        return doctorRepository.chooseDoctor(data.especialidade(), data.data());
    }

    public void cancelar(AppointmentCancelDTO data){
        if(!repository.existsById(data.idConsulta())){
            throw new ValidationException("Id da consulta informado não existe!");
        }

        var consulta = repository.getReferenceById(data.idConsulta());
        consulta.cancelar(data.motivo());
    }

}

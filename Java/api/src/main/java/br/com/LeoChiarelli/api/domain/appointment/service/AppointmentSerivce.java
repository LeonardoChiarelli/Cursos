package br.com.LeoChiarelli.api.domain.appointment.service;

import br.com.LeoChiarelli.api.domain.appointment.dto.AppointmentCancelDTO;
import br.com.LeoChiarelli.api.domain.appointment.dto.AppointmentDTO;
import br.com.LeoChiarelli.api.domain.appointment.dto.AppointmentDetailingDTO;
import br.com.LeoChiarelli.api.domain.appointment.models.Appointment;
import br.com.LeoChiarelli.api.domain.appointment.repository.IAppointmentRepository;
import br.com.LeoChiarelli.api.domain.appointment.validation.IValidation;
import br.com.LeoChiarelli.api.domain.doctor.models.Doctor;
import br.com.LeoChiarelli.api.domain.doctor.repository.IDoctorRepository;
import br.com.LeoChiarelli.api.domain.patient.repository.IPatientRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentSerivce {

    @Autowired
    protected IAppointmentRepository repository;

    @Autowired
    protected IDoctorRepository doctorRepository;

    @Autowired
    protected IPatientRepository patientRepository;

    @Autowired
    protected List<IValidation> validators;

    public AppointmentDetailingDTO schedule(AppointmentDTO data){
        if(!patientRepository.existsById(data.idPaciente())){
            throw new ValidationException("Id do paciente informado, não existe!");
        }

        if(data.idMedico() != null && !doctorRepository.existsById(data.idMedico())){
            throw new ValidationException("Id do médico informado, não existe!");
        }

        validators.forEach(v -> v.validate(data));

        var paciente = patientRepository.getReferenceById(data.idPaciente());
        var medico = chooseDoctor(data);
        if(medico == null){
            throw new RuntimeException("Não há medicos disponíveis nesta data!");
        }

        var consulta = new Appointment(null, medico, paciente, data.data(), null);
        repository.save(consulta);

        return new AppointmentDetailingDTO(consulta);
    }

    private Doctor chooseDoctor(AppointmentDTO data) {
        if(data.idMedico() != null){
            return doctorRepository.getReferenceById(data.idMedico());
        }

        if(data.especialidade() == null){
            throw new ValidationException("Especialidade é obrigatória quando o médico não for escolhido");
        }

        return repository.chooseDoctor(data.especialidade(), data.data());
    }

    public void cancelar(AppointmentCancelDTO data){
        if(!repository.existsById(data.idConsulta())){
            throw new ValidationException("Id da consulta informado não existe!");
        }

        var consulta = repository.getReferenceById(data.idConsulta());
        consulta.cancelar(data.motivo());
    }

}

// SOLID -
    // Single Responsibility Principle
    // Open-Close Principle
    // Liskov Substitution Principle
    // Interface Segregation Principle
    // Dependency Inversion Principle
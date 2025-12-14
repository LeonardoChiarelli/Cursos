package br.com.LeoChiarelli.api.domain.service;

import br.com.LeoChiarelli.api.domain.dto.AppointmentCancelDTO;
import br.com.LeoChiarelli.api.domain.dto.AppointmentDTO;
import br.com.LeoChiarelli.api.domain.dto.AppointmentDetailingDTO;
import br.com.LeoChiarelli.api.domain.models.Appointment;
import br.com.LeoChiarelli.api.domain.repository.IAppointmentRepository;
import br.com.LeoChiarelli.api.domain.validation.IValidation;
import br.com.LeoChiarelli.api.domain.models.Doctor;
import br.com.LeoChiarelli.api.domain.repository.IDoctorRepository;
import br.com.LeoChiarelli.api.domain.repository.IPatientRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppointmentService {

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

        return doctorRepository.chooseRandomDoctor(data.especialidade(), data.data());
    }

    public void cancelar(AppointmentCancelDTO data){
        if(!repository.existsById(data.idConsulta())){
            throw new ValidationException("Id da consulta informado não existe!");
        }

        var consulta = repository.getReferenceById(data.idConsulta());
        consulta.cancelar(data.motivo());
    }

    public Page<AppointmentDetailingDTO> list(Pageable pageable) {
        return repository.findAll(pageable).map(AppointmentDetailingDTO::new);
    }
}

// SOLID -
    // Single Responsibility Principle
    // Open-Close Principle
    // Liskov Substitution Principle
    // Interface Segregation Principle
    // Dependency Inversion Principle
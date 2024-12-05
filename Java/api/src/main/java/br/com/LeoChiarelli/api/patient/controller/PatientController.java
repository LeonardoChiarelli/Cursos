package br.com.LeoChiarelli.api.patient.controller;


import br.com.LeoChiarelli.api.patient.dto.ListPatientDTO;
import br.com.LeoChiarelli.api.patient.dto.PatientDTO;
import br.com.LeoChiarelli.api.patient.dto.PatientDetailingDTO;
import br.com.LeoChiarelli.api.patient.dto.UpdatePatientDTO;
import br.com.LeoChiarelli.api.patient.models.Patient;
import br.com.LeoChiarelli.api.patient.repository.IPatientRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/pacientes")
public class PatientController {

    @Autowired
    private IPatientRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity register(@RequestBody @Valid PatientDTO data, UriComponentsBuilder uriBuilder){
        var paciente = new Patient(data);
        repository.save(paciente);

        var uri = uriBuilder.path("/pacientes/{id}").buildAndExpand(paciente.getId()).toUri();

        return ResponseEntity.created(uri).body(new PatientDetailingDTO(paciente));
    }

    @GetMapping
    public ResponseEntity<Page<ListPatientDTO>> list(@PageableDefault(size = 10, sort = {"nome"})Pageable pageable){
        var page = repository.findAllByAtivoTrue(pageable).map(ListPatientDTO::new);

        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity detail(@PathVariable Long id){
        var paciente = repository.getReferenceById(id);
        return ResponseEntity.ok(new PatientDetailingDTO(paciente));
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid UpdatePatientDTO data){
        var patient = repository.getReferenceById(data.id());
        patient.updateInfo(data);

        return ResponseEntity.ok(new PatientDetailingDTO(patient));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id){
        var patient = repository.getReferenceById(id);
        patient.delete();

        return ResponseEntity.noContent().build();
    }
}

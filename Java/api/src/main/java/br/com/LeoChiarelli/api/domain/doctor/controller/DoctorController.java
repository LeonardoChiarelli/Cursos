package br.com.LeoChiarelli.api.domain.doctor.controller;

import br.com.LeoChiarelli.api.domain.doctor.dto.DoctorDTO;
import br.com.LeoChiarelli.api.domain.doctor.dto.DoctorsDetailingDTO;
import br.com.LeoChiarelli.api.domain.doctor.dto.ListDoctorDTO;
import br.com.LeoChiarelli.api.domain.doctor.dto.UpdateDoctorDTO;
import br.com.LeoChiarelli.api.domain.doctor.models.Doctor;
import br.com.LeoChiarelli.api.domain.doctor.repository.IDoctorRepository;
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
@RequestMapping("/medicos")
public class DoctorController {

    @Autowired
    private IDoctorRepository repository;

    @PostMapping
    @Transactional // Para ter uma transição ativa com o banco de dados, por ser um metodo de escrita (insert)
    public ResponseEntity register(@RequestBody @Valid DoctorDTO data, UriComponentsBuilder uriBuilder){ // Para indicar ao Spring que devemos pegar o corpo da requisição
        var medico = new Doctor(data);
        repository.save(medico); // Usamos o 'Bean Validation' no DTO pois é onde os dados estão chegando

        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();


        return ResponseEntity.created(uri).body(new DoctorsDetailingDTO(medico));
    }

    @GetMapping
    public ResponseEntity<Page<ListDoctorDTO>> list(@PageableDefault(size = 10, sort = {"nome"}) Pageable pageable){ // Para fazer a paginação
        var page = repository.findAllByAtivoTrue(pageable).map(ListDoctorDTO::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity detail(@PathVariable Long id){
        var medico = repository.getReferenceById(id);
        return ResponseEntity.ok(new DoctorsDetailingDTO(medico));
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid UpdateDoctorDTO data){
        var medico = repository.getReferenceById(data.id());
        medico.updateInfo(data);

        return ResponseEntity.ok(new DoctorsDetailingDTO(medico));
    }

    @DeleteMapping("/{id}") // Exclusão Lógica
    @Transactional
    public ResponseEntity delete(@PathVariable Long id){
        var medico = repository.getReferenceById(id);
        medico.deactivate();

        return ResponseEntity.noContent().build();
    }
}

// Código 204 - requisição processada e sem conteúdo (mais apropriado para o 'delete')
// Código 201 - requisição processada e novo recurso criado (mais apropriado para o 'post')
    // devolve no corpo da resposta os dados do novo  recurso/registro criado
    // devolve também um cabeçalho do protocolo HTTP (Location)
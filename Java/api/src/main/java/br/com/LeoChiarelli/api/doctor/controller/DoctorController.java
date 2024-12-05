package br.com.LeoChiarelli.api.doctor.controller;

import br.com.LeoChiarelli.api.doctor.dto.DoctorDTO;
import br.com.LeoChiarelli.api.doctor.dto.ListDoctorDTO;
import br.com.LeoChiarelli.api.doctor.dto.UpdateDoctorDTO;
import br.com.LeoChiarelli.api.doctor.models.Doctor;
import br.com.LeoChiarelli.api.doctor.repository.IDoctorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/medicos")
public class DoctorController {

    @Autowired
    private IDoctorRepository repository;

    @PostMapping
    @Transactional // Para ter uma transição ativa com o banco de dados, por ser um metodo de escrita (insert)
    public void register(@RequestBody @Valid DoctorDTO data){ // Para indicar ao Spring que devemos pegar o corpo da requisição
        repository.save(new Doctor(data)); // Usamos o 'Bean Validation' no DTO pois é onde os dados estão chegando
    }

    @GetMapping
    public Page<ListDoctorDTO> list(@PageableDefault(size = 10, sort = {"nome"}) Pageable pageable){ // Para fazer a paginação
        return repository.findAllByAtivoTrue(pageable).map(ListDoctorDTO::new);
    }

    @PutMapping
    @Transactional
    public void update(@RequestBody @Valid UpdateDoctorDTO data){
        var medico = repository.getReferenceById(data.id());
        medico.updateInfo(data);
    }

    @DeleteMapping("/{id}") // Exclusão Lógica
    @Transactional
    public void delete(@PathVariable Long id){
        var medico = repository.getReferenceById(id);
        medico.deactivate();
    };
}

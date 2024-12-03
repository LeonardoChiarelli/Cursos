package br.com.LeoChiarelli.api.doctor.controller;

import br.com.LeoChiarelli.api.doctor.dto.DoctorDTO;
import br.com.LeoChiarelli.api.doctor.models.Doctor;
import br.com.LeoChiarelli.api.doctor.repository.IDoctorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

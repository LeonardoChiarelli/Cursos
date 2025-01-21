package br.com.LeoChiarelli.api.domain.controller;

import br.com.LeoChiarelli.api.domain.dto.AppointmentCancelDTO;
import br.com.LeoChiarelli.api.domain.dto.AppointmentDTO;
import br.com.LeoChiarelli.api.domain.dto.AppointmentDetailingDTO;
import br.com.LeoChiarelli.api.domain.service.AppointmentService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultas")
@SecurityRequirement(name = "bearer-key")
public class AppointmentController {

    @Autowired
    private AppointmentService serivce;

    @GetMapping
    public ResponseEntity<Page<AppointmentDetailingDTO>> list(Pageable pageable){
        return ResponseEntity.ok(serivce.list(pageable));
    }

    @PostMapping
    @Transactional
    public ResponseEntity schedule(@RequestBody @Valid AppointmentDTO data){

        var dto = serivce.schedule(data);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity cancel(@RequestBody @Valid AppointmentCancelDTO data){
        serivce.cancelar(data);
        return ResponseEntity.noContent().build();
    }
}

package br.com.LeoChiarelli.api.domain.appointment.controller;

import br.com.LeoChiarelli.api.domain.appointment.dto.AppointmentCancelDTO;
import br.com.LeoChiarelli.api.domain.appointment.dto.AppointmentDTO;
import br.com.LeoChiarelli.api.domain.appointment.dto.AppointmentDetailingDTO;
import br.com.LeoChiarelli.api.domain.appointment.service.AppointmentSerivce;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consultas")
@SecurityRequirement(name = "bearer-key")
public class AppointmentController {

    @Autowired
    private AppointmentSerivce serivce;

    @PostMapping
    @Transactional
    public ResponseEntity scheduleAnAppointment(@RequestBody @Valid AppointmentDTO data){

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

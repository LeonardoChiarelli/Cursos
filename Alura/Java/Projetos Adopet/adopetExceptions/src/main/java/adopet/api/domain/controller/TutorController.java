package adopet.api.domain.controller;


import adopet.api.domain.dto.CadastroTutorDTO;
import adopet.api.domain.dto.TutorDTO;
import adopet.api.domain.service.TutorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tutor")
public class TutorController {

    @Autowired
    private TutorService service;

    @GetMapping
    public ResponseEntity<List<TutorDTO>> buscarTodos(){
        List<TutorDTO> tutores = service.listarTodos();
        return ResponseEntity.ok(tutores);
    }

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid CadastroTutorDTO dados){

        this.service.cadastrar(dados);
    }


}

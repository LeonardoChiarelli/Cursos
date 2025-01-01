package adopet.api.domain.controller;

import adopet.api.domain.dto.AdocaoDTO;
import adopet.api.domain.dto.AprovarAdocaoDTO;
import adopet.api.domain.dto.ReprovarAdocaoDTO;
import adopet.api.domain.dto.SolicitacaoDeAdocaoDTO;
import adopet.api.domain.service.AdocaoService;
import adopet.api.general.exception.ValidacaoException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adocao")
public class AdocaoController {

    @Autowired
    private AdocaoService service;

    @GetMapping
    public ResponseEntity<List<AdocaoDTO>> buscarTodos(){
        List<AdocaoDTO> adocoes = service.listarTodos();
        return ResponseEntity.ok(adocoes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdocaoDTO> buscar(@PathVariable Long id){
        AdocaoDTO adocao = service.listar(id);
        return ResponseEntity.ok(adocao);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<String> solicitar(@RequestBody @Valid SolicitacaoDeAdocaoDTO dados){
        this.service.solicitar(dados);
        return ResponseEntity.ok("Adoção solicitada com sucesso!");
    }

    @PutMapping("/aprovar")
    @Transactional
    public ResponseEntity<String> aprovar(@RequestBody @Valid AprovarAdocaoDTO dto){
        this.service.aprovar(dto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/reprovar")
    @Transactional
    public ResponseEntity<String> reprovar(@RequestBody @Valid ReprovarAdocaoDTO dto){
        try {
            this.service.reprovar(dto);
        } catch (EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não há uma adoção com este id");
        }
        return ResponseEntity.ok().build();
    }
}

package adopet.api.domain.service;

import adopet.api.domain.dto.CadastroPetDTO;
import adopet.api.domain.dto.PetDTO;
import adopet.api.domain.model.Pet;
import adopet.api.domain.repository.IPetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.List;

@Service
public class PetService {

    @Autowired
    private IPetRepository repository;

    @Autowired
    private ImageStorageService imagemService;

    public List<PetDTO> listarTodos(){
        return repository.findAll().stream().map(PetDTO::new).toList();
    }
    public void cadastrar(CadastroPetDTO dto, MultipartFile imagem) throws IOException {

        String nomeImagem = imagemService.upload(imagem);

        repository.save(new Pet(dto, nomeImagem));
    }
}

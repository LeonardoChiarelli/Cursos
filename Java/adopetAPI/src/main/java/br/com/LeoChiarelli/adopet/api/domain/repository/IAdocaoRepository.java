package br.com.LeoChiarelli.adopet.api.domain.repository;

import br.com.LeoChiarelli.adopet.api.domain.model.Adocao;
import br.com.LeoChiarelli.adopet.api.domain.model.StatusAdocao;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IAdocaoRepository extends JpaRepository<Adocao, Long> {

    boolean existsByPetIdAndStatus(@NotNull Long idPet, StatusAdocao status);

    boolean existsByTutorIdAndStatus(@NotNull Long idTutor, StatusAdocao status);

    List<Adocao> findByTutorId(@NotNull Long idTutor);
}

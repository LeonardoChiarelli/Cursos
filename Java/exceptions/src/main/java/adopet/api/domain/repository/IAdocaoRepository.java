package adopet.api.domain.repository;

import adopet.api.domain.model.Adocao;
import adopet.api.domain.model.Pet;
import adopet.api.domain.model.StatusAdocao;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAdocaoRepository extends JpaRepository<Adocao,Long> {

    boolean existsByPetIdAndStatus(@NotNull Long idPet, StatusAdocao status);

    int countByTutorIdAndStatus(@NotNull Long idTutor, StatusAdocao status);

}

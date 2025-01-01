package adopet.api.domain.repository;

import adopet.api.domain.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPetRepository extends JpaRepository<Pet, Long> {
}

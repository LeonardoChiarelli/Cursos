package adopet.api.domain.repository;

import adopet.api.domain.model.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITutorRepository extends JpaRepository<Tutor, Long> {
}

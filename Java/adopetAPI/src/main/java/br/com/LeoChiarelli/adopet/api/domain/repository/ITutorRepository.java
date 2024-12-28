package br.com.LeoChiarelli.adopet.api.domain.repository;

import br.com.LeoChiarelli.adopet.api.domain.model.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITutorRepository extends JpaRepository<Tutor, Long> {

    boolean existsByTelefoneOrEmail(String telefone, String email);
}

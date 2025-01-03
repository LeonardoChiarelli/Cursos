package br.com.LeoChiarelli.adopetThreads.domain.repository;

import br.com.LeoChiarelli.adopetThreads.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByEmail(String email);
}

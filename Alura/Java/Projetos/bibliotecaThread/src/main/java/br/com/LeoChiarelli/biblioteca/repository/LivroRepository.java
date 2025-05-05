package br.com.LeoChiarelli.biblioteca.repository;

import br.com.LeoChiarelli.biblioteca.model.Livro;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import java.util.Optional;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    @Lock(LockModeType.OPTIMISTIC)
    Optional<Livro> findById(Long id);

}

package br.com.LeoChiarelli.adopet.api.domain.repository;

import br.com.LeoChiarelli.adopet.api.domain.model.Abrigo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAbrigoRepository extends JpaRepository<Abrigo, Long> {
    Abrigo findByNome(String nome);

    boolean existsByNomeOrTelefoneOrEmail(String nome, String telefone, String email);
}

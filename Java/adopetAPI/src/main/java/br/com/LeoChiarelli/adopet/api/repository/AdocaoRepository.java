package br.com.LeoChiarelli.adopet.api.repository;

import br.com.LeoChiarelli.adopet.api.model.Adocao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdocaoRepository extends JpaRepository<Adocao, Long> {

}

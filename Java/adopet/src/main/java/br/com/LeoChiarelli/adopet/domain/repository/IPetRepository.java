package br.com.LeoChiarelli.adopet.domain.repository;

import br.com.LeoChiarelli.adopet.domain.models.Pet;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IPetRepository extends JpaRepository<Pet, Long> {

    @Query("SELECT p FROM Pet p WHERE p.abrigo_id = :idAbrigo")
    Page<Pet> findAllPets(Long idAbrigo);
}

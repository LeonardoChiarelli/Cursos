package br.com.LeoChiarelli.adopet.api.repository;

import br.com.LeoChiarelli.adopet.api.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Long> {

}

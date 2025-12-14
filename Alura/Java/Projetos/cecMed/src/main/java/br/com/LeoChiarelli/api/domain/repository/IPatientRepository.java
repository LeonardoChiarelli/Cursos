package br.com.LeoChiarelli.api.domain.repository;

import br.com.LeoChiarelli.api.domain.models.Patient;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPatientRepository extends JpaRepository<Patient, Long> {

    Page<Patient> findAllByAtivoTrue(Pageable pageable);

    boolean existsById(@NotNull Long idPaciente);
}

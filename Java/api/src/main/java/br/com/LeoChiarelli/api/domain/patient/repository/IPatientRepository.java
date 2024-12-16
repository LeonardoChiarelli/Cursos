package br.com.LeoChiarelli.api.domain.patient.repository;

import br.com.LeoChiarelli.api.domain.patient.models.Patient;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IPatientRepository extends JpaRepository<Patient, Long> {

    Page<Patient> findAllByAtivoTrue(Pageable pageable);

    boolean existsById(@NotNull Long idPaciente);
}

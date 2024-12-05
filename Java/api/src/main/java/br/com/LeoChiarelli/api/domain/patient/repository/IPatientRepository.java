package br.com.LeoChiarelli.api.domain.patient.repository;

import br.com.LeoChiarelli.api.domain.patient.models.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPatientRepository extends JpaRepository<Patient, Long> {

    Page<Patient> findAllByAtivoTrue(Pageable pageable);

}

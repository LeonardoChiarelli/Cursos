package br.com.LeoChiarelli.api.doctor.repository;

import br.com.LeoChiarelli.api.doctor.models.Doctor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDoctorRepository extends JpaRepository<Doctor, Long> {

    Page<Doctor> findAllByAtivoTrue(Pageable pageable);
}

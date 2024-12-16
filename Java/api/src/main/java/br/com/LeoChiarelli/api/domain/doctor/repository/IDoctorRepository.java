package br.com.LeoChiarelli.api.domain.doctor.repository;

import br.com.LeoChiarelli.api.domain.doctor.models.Doctor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface IDoctorRepository extends JpaRepository<Doctor, Long> {

    Page<Doctor> findAllByAtivoTrue(Pageable pageable);

    @Query("SELECT m.ativo FROM Medico m WHERE m.id = :idMedico")
    boolean findAtivoById(Long idMedico);
}

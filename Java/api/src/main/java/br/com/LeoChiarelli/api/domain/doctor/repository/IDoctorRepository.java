package br.com.LeoChiarelli.api.domain.doctor.repository;

import br.com.LeoChiarelli.api.domain.doctor.models.Doctor;
import br.com.LeoChiarelli.api.domain.doctor.models.Specialty;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.Optional;

public interface IDoctorRepository extends JpaRepository<Doctor, Long> {

    Page<Doctor> findAllByAtivoTrue(Pageable pageable);

    @Query("SELECT m FROM Medico m WHERE m.ativo = true AND m.especialidade = :especialidade AND m.id NOT in(SELECT c.medico_id FROM Consulta c WHERE c.data = :data) ORDER BY rand() LIMIT 1")
    Doctor chooseDoctor(Specialty especialidade, @NotNull @Future LocalDateTime data);

    @Query("SELECT m.ativo FROM Medico m WHERE m.id = :idMedico")
    Boolean findAtivoById(Long idMedico);

    Boolean existsByMedicoIdAndData(Long idMedico, LocalDateTime data);
}

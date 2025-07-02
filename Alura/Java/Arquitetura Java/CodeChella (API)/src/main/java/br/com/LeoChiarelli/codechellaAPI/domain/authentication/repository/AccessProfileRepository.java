package br.com.LeoChiarelli.codechellaAPI.domain.authentication.repository;

import br.com.LeoChiarelli.codechellaAPI.domain.authentication.entity.AccessProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccessProfileRepository extends JpaRepository<AccessProfile, Long> {

    AccessProfile findByName(String name);

}

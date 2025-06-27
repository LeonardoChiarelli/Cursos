package br.com.LeoChiarelli.codechella.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Boolean existsBySsn(String ssn);

    UserEntity findBySsn(String ssn);
}

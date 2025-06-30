package br.com.LeoChiarelli.codechellaDDD.infrastructure.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}

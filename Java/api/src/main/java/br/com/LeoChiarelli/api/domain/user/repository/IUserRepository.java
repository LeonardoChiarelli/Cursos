package br.com.LeoChiarelli.api.domain.user.repository;

import br.com.LeoChiarelli.api.domain.user.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface IUserRepository extends JpaRepository<User, Long> {

    UserDetails findByLogin(String login);
}

package br.com.LeoChiarelli.codechella.application.gateways;

import br.com.LeoChiarelli.codechella.domain.entities.user.User;

import java.util.List;

public interface RepositoryOfUser {

    User registryUser(User user);

    List<User> listAll();
}

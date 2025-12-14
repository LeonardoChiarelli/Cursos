package br.com.LeoChiarelli.codechellaTDD.application.gateways;

import br.com.LeoChiarelli.codechellaTDD.domain.entities.user.User;

import java.util.List;

public interface RepositoryOfUser {

    User registryUser(User user);

    List<User> listAll();

    User updateUser(String ssn, String email);

    void deleteUser(String ssn);
}

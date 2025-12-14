package br.com.LeoChiarelli.codechellaTDD.application.useCases;

import br.com.LeoChiarelli.codechellaTDD.application.gateways.RepositoryOfUser;
import br.com.LeoChiarelli.codechellaTDD.domain.entities.user.User;

import java.util.List;

public class ListUsersImplementation{

    private final RepositoryOfUser repository;

    public ListUsersImplementation(RepositoryOfUser repository){ this.repository = repository; }

    public List<User> listAll() {
        return repository.listAll();
    }
}

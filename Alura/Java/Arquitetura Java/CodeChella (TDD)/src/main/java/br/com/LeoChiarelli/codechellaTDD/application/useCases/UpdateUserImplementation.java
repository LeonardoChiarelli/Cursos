package br.com.LeoChiarelli.codechellaTDD.application.useCases;

import br.com.LeoChiarelli.codechellaTDD.application.gateways.RepositoryOfUser;
import br.com.LeoChiarelli.codechellaTDD.domain.entities.user.User;

public class UpdateUserImplementation {

    public final RepositoryOfUser repository;

    public UpdateUserImplementation (RepositoryOfUser repository) {
        this.repository = repository;
    }

    public User updateUser (String ssn, String email) { return repository.updateUser(ssn, email); }
}

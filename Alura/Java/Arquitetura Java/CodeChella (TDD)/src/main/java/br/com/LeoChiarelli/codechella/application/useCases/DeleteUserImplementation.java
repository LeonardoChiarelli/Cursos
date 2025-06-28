package br.com.LeoChiarelli.codechella.application.useCases;

import br.com.LeoChiarelli.codechella.application.gateways.RepositoryOfUser;

public class DeleteUserImplementation {

    public final RepositoryOfUser repository;

    public DeleteUserImplementation (RepositoryOfUser repository) {
        this.repository = repository;
    }

    public void deleteUser(String ssn) { repository.deleteUser(ssn); }
}

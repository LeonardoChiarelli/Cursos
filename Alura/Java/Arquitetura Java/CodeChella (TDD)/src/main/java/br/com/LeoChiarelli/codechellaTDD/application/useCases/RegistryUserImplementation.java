package br.com.LeoChiarelli.codechellaTDD.application.useCases;

import br.com.LeoChiarelli.codechellaTDD.application.gateways.RepositoryOfUser;
import br.com.LeoChiarelli.codechellaTDD.domain.entities.user.User;

public class RegistryUserImplementation{

    private final RepositoryOfUser repository;

    public RegistryUserImplementation(RepositoryOfUser repository){ this.repository = repository; }

    public User registryUser(User user){
        return repository.registryUser(user);
    }
}

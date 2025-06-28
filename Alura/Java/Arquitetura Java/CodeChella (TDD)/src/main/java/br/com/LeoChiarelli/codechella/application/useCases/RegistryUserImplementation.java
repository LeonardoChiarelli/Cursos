package br.com.LeoChiarelli.codechella.application.useCases;

import br.com.LeoChiarelli.codechella.application.gateways.RepositoryOfUser;
import br.com.LeoChiarelli.codechella.domain.entities.user.User;

public class RegistryUserImplementation{

    private final RepositoryOfUser repository;

    public RegistryUserImplementation(RepositoryOfUser repository){ this.repository = repository; }

    public User registryUser(User user){
        return repository.registryUser(user);
    }
}

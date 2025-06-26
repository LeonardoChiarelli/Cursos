package br.com.LeoChiarelli.codechella.infrastructure.gateways;

import br.com.LeoChiarelli.codechella.infrastructure.persistence.UserRepository;
import br.com.LeoChiarelli.codechella.application.gateways.RepositoryOfUser;
import br.com.LeoChiarelli.codechella.domain.entities.user.User;

import java.util.List;

public class UserRepositoryJPA implements RepositoryOfUser {

    private final UserRepository repository;
    private final UserEntityMapper mapper;

    public UserRepositoryJPA(UserRepository repository, UserEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public User registryUser(User user) {
        var userEntity = mapper.toEntity(user);
        repository.save(userEntity);
        return mapper.toDomain(userEntity);
    }

    @Override
    public List<User> listAll() {
        // return repository.findAll();
        return null;
    }
}

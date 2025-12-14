package br.com.LeoChiarelli.codechellaTDD.infrastructure.gateways;

import br.com.LeoChiarelli.codechellaTDD.infrastructure.persistence.UserRepository;
import br.com.LeoChiarelli.codechellaTDD.application.gateways.RepositoryOfUser;
import br.com.LeoChiarelli.codechellaTDD.domain.entities.user.User;

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
        return repository.findAll().stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public User updateUser(String ssn, String email) {
        var userEntity = repository.existsBySsn(ssn);
        if (!userEntity) { throw new IllegalArgumentException("User not found"); }

        var entity = repository.findBySsn(ssn);
        entity.setEmail(email);
        repository.save(entity);
        return mapper.toDomain(entity);
    }

    @Override
    public void deleteUser(String ssn) {
        var userEntity = repository.existsBySsn(ssn);
        if (!userEntity) { throw new IllegalArgumentException("User not found"); }

        var entity = repository.findBySsn(ssn);
        repository.deleteById(entity.getId());
    }
}

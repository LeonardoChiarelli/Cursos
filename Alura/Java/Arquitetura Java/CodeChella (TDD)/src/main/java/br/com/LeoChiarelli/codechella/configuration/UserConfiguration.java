package br.com.LeoChiarelli.codechella.configuration;

import br.com.LeoChiarelli.codechella.application.gateways.RepositoryOfUser;
import br.com.LeoChiarelli.codechella.application.useCases.DeleteUserImplementation;
import br.com.LeoChiarelli.codechella.application.useCases.ListUsersImplementation;
import br.com.LeoChiarelli.codechella.application.useCases.RegistryUserImplementation;
import br.com.LeoChiarelli.codechella.application.useCases.UpdateUserImplementation;
import br.com.LeoChiarelli.codechella.infrastructure.gateways.UserEntityMapper;
import br.com.LeoChiarelli.codechella.infrastructure.gateways.UserRepositoryJPA;
import br.com.LeoChiarelli.codechella.infrastructure.persistence.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfiguration {

    @Bean
    public RegistryUserImplementation registryUser(RepositoryOfUser repositoryOfUser) {
        return new RegistryUserImplementation(repositoryOfUser);
    }

    @Bean
    public UserRepositoryJPA userRepositoryJPA(UserRepository userRepository, UserEntityMapper mapper) {
        return new UserRepositoryJPA(userRepository, mapper);
    }

    @Bean
    public UserEntityMapper entityMapper() {
        return new UserEntityMapper();
    }

    @Bean
    public ListUsersImplementation listUsers(RepositoryOfUser repositoryOfUser) {
        return new ListUsersImplementation(repositoryOfUser);
    }

    @Bean
    public UpdateUserImplementation updateUser(RepositoryOfUser repositoryOfUser) {
        return new UpdateUserImplementation(repositoryOfUser);
    }

    @Bean
    public DeleteUserImplementation DeleteUser(RepositoryOfUser repositoryOfUser) {
        return new DeleteUserImplementation(repositoryOfUser);
    }
}

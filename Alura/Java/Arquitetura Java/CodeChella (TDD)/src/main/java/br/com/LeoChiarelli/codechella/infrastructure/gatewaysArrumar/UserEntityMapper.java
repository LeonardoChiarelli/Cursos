package br.com.LeoChiarelli.codechella.infrastructure.gatewaysArrumar;

import br.com.LeoChiarelli.codechella.domain.entities.user.User;
import br.com.LeoChiarelli.codechella.infrastructure.persistence.UserEntity;

public class UserEntityMapper {

    public UserEntity toEntity(User user){
        return new UserEntity(user.getSsn(), user.getName(), user.getBirth(), user.getEmail());
    }

    public User toDomain(UserEntity userEntity){
        return new User(userEntity.getSsn(), userEntity.getName(), userEntity.getBirth(), userEntity.getEmail());
    }
}

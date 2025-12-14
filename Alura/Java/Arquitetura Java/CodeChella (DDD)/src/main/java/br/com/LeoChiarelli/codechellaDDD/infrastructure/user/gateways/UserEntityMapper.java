package br.com.LeoChiarelli.codechellaDDD.infrastructure.user.gateways;

import br.com.LeoChiarelli.codechellaDDD.domain.user.User;
import br.com.LeoChiarelli.codechellaDDD.infrastructure.user.UserEntity;

public class UserEntityMapper {

    public static UserEntity toEntity(User userDomain){
        return new UserEntity(userDomain.getSsn(), userDomain.getName(), userDomain.getBirth(), userDomain.getEmail());
    }

    public static User toDomain(UserEntity userEntity){
        return User.builder()
                .withSsn(userEntity.getSsn())
                .withName(userEntity.getName())
                .withBirth(userEntity.getBirth())
                .withEmail(userEntity.getEmail())
                .build();
    }
}

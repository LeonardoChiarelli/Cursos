package br.com.LeoChiarelli.codechella.infrastructure.gatewaysArrumar;

import br.com.LeoChiarelli.codechella.infrastructure.dto.RegistryUserDTO;
import br.com.LeoChiarelli.codechella.infrastructure.dto.UserDataDTO;
import br.com.LeoChiarelli.codechella.infrastructure.persistence.user.UserEntity;
import br.com.LeoChiarelli.codechella.infrastructure.persistence.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public UserDataDTO registryUser(RegistryUserDTO dto) {
        UserEntity userEntity = new UserEntity(dto);
        repository.save(userEntity);
        return convertData(userEntity);
    }

    public List<UserDataDTO> listAll() {
        return repository.findAll().stream()
                .map(this::convertData)
                .collect(Collectors.toList());
    }

    private UserDataDTO convertData(UserEntity userEntity) {
        return new UserDataDTO(userEntity.getId(), userEntity.getSsn(),
                userEntity.getName(), userEntity.getBirth(), userEntity.getEmail());
    }
}

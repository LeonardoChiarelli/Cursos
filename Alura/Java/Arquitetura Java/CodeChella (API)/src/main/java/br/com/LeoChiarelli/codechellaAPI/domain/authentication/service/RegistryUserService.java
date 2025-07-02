package br.com.LeoChiarelli.codechellaAPI.domain.authentication.service;

import br.com.LeoChiarelli.codechellaAPI.domain.BusinessRuleException;
import br.com.LeoChiarelli.codechellaAPI.domain.authentication.entity.AccessProfile;
import br.com.LeoChiarelli.codechellaAPI.domain.authentication.entity.User;
import br.com.LeoChiarelli.codechellaAPI.domain.authentication.repository.AccessProfileRepository;
import br.com.LeoChiarelli.codechellaAPI.domain.authentication.repository.UserRepository;
import br.com.LeoChiarelli.codechellaAPI.domain.authentication.valueObject.RegistryUserDataDTO;
import br.com.LeoChiarelli.codechellaAPI.domain.authentication.valueObject.UserDataDTO;
import br.com.LeoChiarelli.codechellaAPI.domain.email.EmailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RegistryUserService {

    private final UserRepository userRepository;
    private final AccessProfileRepository accessProfileRepository;
    private final PasswordEncoder passwordEncoder;
    private final EmailSender emailSender;

    public RegistryUserService(UserRepository userRepository, AccessProfileRepository accessProfileRepository, PasswordEncoder passwordEncoder, EmailSender emailSender) {
        this.userRepository = userRepository;
        this.accessProfileRepository = accessProfileRepository;
        this.passwordEncoder = passwordEncoder;
        this.emailSender = emailSender;
    }

    public UserDataDTO registryUser(RegistryUserDataDTO dto) {
        if (userRepository.existsByEmailOrSsn(dto.email(), dto.ssn())) {
            throw new BusinessRuleException("Email and/or SSN already registered!");
        }

        var randomPassword = generateRandomNumericPassword();
        var passwordHash = passwordEncoder.encode(randomPassword);
        var costumerProfile = loadCostumerProfile();
        var user = new User(dto, passwordHash, Set.of(costumerProfile));

        userRepository.save(user);
        sendEmail(user, randomPassword);

        return new UserDataDTO(user);
    }

    private String generateRandomNumericPassword() {
        return new Random()
                .ints(0, 10)
                .limit(6)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining());
    }

    private AccessProfile loadCostumerProfile() {
        return accessProfileRepository.findByName(AccessProfile.COSTUMER);
    }

    private void sendEmail(User user, String password) {
        var recipient = user.getEmail();
        var subject = "Welcome to CodeChella!";
        var message = "Your registration has been successful! Access the website with your email and this password: " + password;
        emailSender.send(recipient, subject, message);
    }

}

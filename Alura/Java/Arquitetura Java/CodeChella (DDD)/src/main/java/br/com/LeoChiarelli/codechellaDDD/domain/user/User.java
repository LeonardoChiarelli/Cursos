package br.com.LeoChiarelli.codechellaDDD.domain.user;

import br.com.LeoChiarelli.codechellaDDD.application.ValidationException;

import java.time.LocalDate;

public class User {

    private final String ssn;
    private final String name;
    private final LocalDate birth;
    private final String email;

    private User(String ssn, String name, LocalDate birth, String email) {
        if (ssn == null || ssn.trim().isEmpty() || name == null || name.trim().isEmpty() || birth == null || email == null || email.trim().isEmpty()) {
            throw new ValidationException("All core user must be provided. ");
        }
        this.ssn = ssn;
        this.name = name;
        this.birth = birth;
        this.email = email;
    }

    public static UserBuilder builder(){
        return new UserBuilder();
    }

    public String getSsn() {
        return ssn;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public String getEmail() {
        return email;
    }

    public static class UserBuilder {
        private String ssn;
        private String name;
        private LocalDate birth;
        private String email;

        public UserBuilder() {
        }

        public UserBuilder withSsn(String ssn) {
            this.ssn = ssn;
            return this;
        }

        public UserBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public UserBuilder withBirth(LocalDate birth) {
            this.birth = birth;
            return this;
        }

        public UserBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public User build() {
            if (ssn == null || ssn.trim().isEmpty()) {
                throw new ValidationException("User ssn must not be null.");
            }
            if (name == null || name.trim().isEmpty()) {
                throw new ValidationException("User name must not be null.");
            }
            if (birth == null) {
                throw new ValidationException("User birth must not be null.");
            }
            if (email == null || email.trim().isEmpty()) {
                throw new ValidationException("User email must not be null.");
            }

            return new User(ssn, name, birth, email);
        }
    }
}

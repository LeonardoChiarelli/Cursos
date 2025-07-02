package br.com.LeoChiarelli.codechellaAPI.domain.authentication.entity;

import br.com.LeoChiarelli.codechellaAPI.domain.authentication.valueObject.RegistryUserDataDTO;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String ssn;

    private String email;

    private LocalDate birth;

    private String password;

    @ManyToMany
    @JoinTable(name = "users_profiles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "profile_id"))
    private Set<AccessProfile> profiles = new HashSet<>();

    public User() {}

    public User(RegistryUserDataDTO dto, String passwordHash, Set<AccessProfile> profiles) {
        this.name = dto.name();
        this.ssn = dto.ssn();
        this.email = dto.email();
        this.birth = dto.birth();
        this.password = passwordHash;
        this.profiles.addAll(profiles);
    }

    public boolean isAdmin() {
        return this.profiles.stream().anyMatch(AccessProfile::isAdmin);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(ssn, user.ssn);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.profiles;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ssn);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSsn() {
        return ssn;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public Set<AccessProfile> getProfiles() {
        return profiles;
    }

}

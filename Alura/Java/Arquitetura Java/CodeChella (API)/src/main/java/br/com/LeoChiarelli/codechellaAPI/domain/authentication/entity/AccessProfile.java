package br.com.LeoChiarelli.codechellaAPI.domain.authentication.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.security.core.GrantedAuthority;

import java.util.Objects;

@Entity
@Table(name = "access_profiles")
public class AccessProfile implements GrantedAuthority {

    public static final String COSTUMER = "ROLE_COSTUMER";
    public static final String ADMIN = "ROLE_ADMIN";

    @Id
    private Long id;
    private String name;

    public AccessProfile() {}

    public AccessProfile(String name) {
        this.name = name;
    }

    public boolean isAdmin() {
        return this.name.equals(ADMIN);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccessProfile that = (AccessProfile) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String getAuthority() {
        return this.name;
    }

}

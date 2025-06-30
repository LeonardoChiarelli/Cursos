package br.com.LeoChiarelli.codechellaDDD.infrastructure.user;

import br.com.LeoChiarelli.codechellaDDD.application.user.RegistryUserDTO;
import br.com.LeoChiarelli.codechellaDDD.infrastructure.sale.SaleEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ssn;
    private String name;
    private LocalDate birth;
    private String email;

    @OneToOne(mappedBy = "user")
    @JsonIgnore
    private SaleEntity sale;

    public UserEntity() {}

    public UserEntity(RegistryUserDTO dto) {
        this.ssn = dto.ssn();
        this.name = dto.name();
        this.birth = dto.birth();
        this.email = dto.email();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

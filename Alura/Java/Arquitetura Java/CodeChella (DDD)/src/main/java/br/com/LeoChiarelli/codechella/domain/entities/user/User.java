package br.com.LeoChiarelli.codechella.domain.entities.user;

import java.time.LocalDate;

public class User {

    private String ssn;
    private String name;
    private LocalDate birth;
    private String email;

    public User() {}

    public User(String ssn, String name, LocalDate birth, String email) {
        this.ssn = ssn;
        this.name = name;
        this.birth = birth;
        this.email = email;
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

package br.com.LeoChiarelli.codechella.domain.entities.user;

import br.com.LeoChiarelli.codechella.domain.Address;

import java.time.LocalDate;
import java.time.Period;

public class User { // Entity inside Clean Architecture is some class that has a unique ID

    private String ssn; // ID
    private String name;
    private LocalDate birth;
    private String email;
    private Address address;

    public User() {}

    public User(String ssn, String name, LocalDate birth, String email) {

        if (ssn == null || !ssn.matches("\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}")){
            throw new IllegalArgumentException("SSN cannot be null or doesn't match with the pattern");
        }

        if (Period.between( birth, LocalDate.now()).getYears() < 18) {
            throw new IllegalArgumentException("User is a teenager yet");
        }

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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "ssn='" + ssn + '\'' +
                ", name='" + name + '\'' +
                ", birth=" + birth +
                ", email='" + email + '\'' +
                ", address=" + address +
                '}';
    }
}

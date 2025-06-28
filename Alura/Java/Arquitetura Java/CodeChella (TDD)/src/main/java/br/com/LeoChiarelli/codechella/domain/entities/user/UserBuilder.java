package br.com.LeoChiarelli.codechella.domain.entities.user;

import br.com.LeoChiarelli.codechella.domain.Address;

import java.time.LocalDate;

public class UserBuilder {
    private User user;

    public User userWithNameSSNBirthAndEmail(String name, String ssn, LocalDate birth, String email){
        this.user = new User(ssn, name, birth, email);
        return this.user;
    }

    public User includeAddress(String postalCode, Integer number, String complement){
        this.user.setAddress(new Address(postalCode, number, complement));
        return this.user;
    }
}

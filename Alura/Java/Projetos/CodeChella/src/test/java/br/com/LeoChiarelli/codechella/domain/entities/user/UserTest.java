package br.com.LeoChiarelli.codechella.domain.entities.user;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Period;

public class UserTest {

    @Test
    public void shouldNotRegistryAnUserWithSSNInAInvalidFormat(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new User("11111111111", "Leonardo", LocalDate.of(2006, 3, 16), "lrchiarelli@gmail.com"));

        Assertions.assertThrows(IllegalArgumentException.class, () -> new User("111.11111111", "Leonardo", LocalDate.of(2006, 3, 16), "lrchiarelli@gmail.com"));

        Assertions.assertThrows(IllegalArgumentException.class, () -> new User("111.111.11111", "Leonardo", LocalDate.of(2006, 3, 16), "lrchiarelli@gmail.com"));

        Assertions.assertThrows(IllegalArgumentException.class, () -> new User("111.111111-11", "Leonardo", LocalDate.of(2006, 3, 16), "lrchiarelli@gmail.com"));

        Assertions.assertThrows(IllegalArgumentException.class, () -> new User("111111111-11", "Leonardo", LocalDate.of(2006, 3, 16), "lrchiarelli@gmail.com"));
    }

    @Test
    public void shouldNotRegistryAnUserWithNullSSN(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new User(null, "Leonardo", LocalDate.of(2006, 3, 16), "lrchiarelli@gmail.com"));
    }

    @Test
    public void shouldRegistryUserWithBuilder(){
        var builder = new UserBuilder();
        var user = builder.userWithNameSSNBirthAndEmail("Leonardo", "111.111.111-11", LocalDate.of(2006, 3, 16), "lrchiarelli@gmail.com");

        Assertions.assertEquals("Leonardo", user.getName());

        user = builder.includeAddress("11111-111", 231, "apto 002");

        Assertions.assertEquals(231, user.getAddress().getNumber());
    }

    @Test
    public void shouldNotRegistryATeenagerUser(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            var builder = new UserBuilder();
            var user = builder.userWithNameSSNBirthAndEmail("Leonardo", "111.111.111-11", LocalDate.of(2009, 2, 12), "lrchiarrelli@gmail.com");
        });
    }
}

package br.com.LeoChiarelli.codechella;

import br.com.LeoChiarelli.codechella.domain.entities.user.User;
import br.com.LeoChiarelli.codechella.infrastructure.gateways.UserRepositoryTXT;

import java.io.IOException;
import java.time.LocalDate;

public class CodechellaApplicationTXT {

    public static void main(String[] args) throws IOException {
        var repository = new UserRepositoryTXT();

        repository.registryUser(new User("111.111.111-11", "Leonardo", LocalDate.of(2006, 3, 16), "lrchiarelli@gmail,com"));
        repository.registryUser(new User("111.222.111-11", "Rosalngela", LocalDate.of(2000, 4, 14), "rosangela@gmail,com"));
        repository.registryUser(new User("111.333.111-11", "Antonio", LocalDate.of(2001, 1, 26), "antonio@gmail,com"));
        repository.registryUser(new User("111.444.111-11", "Claudio", LocalDate.of(2003, 2, 21), "claudio@gmail,com"));

        repository.listAll().forEach(System.out::println);
        repository.registryInAFile("All Users.txt");

        repository.updateUser("111.111.111-11", "devlechiarelli@gmail.com");
        repository.updateUser("111.333.111-11", "devantonio@gmail.com");

        System.out.println("\n");
        repository.listAll().forEach(System.out::println);
        repository.registryInAFile("All Users With Email's Modification.txt");

        repository.deleteUser("111.222.111-11");
        repository.deleteUser("111.444.111-11");

        System.out.println("\n");
        repository.listAll().forEach(System.out::println);
        repository.registryInAFile("Only two Users.txt");
    }
}

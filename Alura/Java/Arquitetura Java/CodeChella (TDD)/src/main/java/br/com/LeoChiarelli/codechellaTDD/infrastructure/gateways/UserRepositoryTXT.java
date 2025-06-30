package br.com.LeoChiarelli.codechellaTDD.infrastructure.gateways;

import br.com.LeoChiarelli.codechellaTDD.application.gateways.RepositoryOfUser;
import br.com.LeoChiarelli.codechellaTDD.domain.entities.user.User;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryTXT implements RepositoryOfUser {

    List<User> userList = new ArrayList<>();

    @Override
    public User registryUser(User user) {
        this.userList.add(user);
        return user;
    }

    @Override
    public List<User> listAll() {
        return this.userList;
    }

    @Override
    public User updateUser(String ssn, String email) {
        for (User u : this.userList){
            if (u.getSsn().equals(ssn)){
                u.setEmail(email);
                return u;
            }
        }

        throw new IllegalArgumentException("User with this SSN not found");
    }

    @Override
    public void deleteUser(String ssn) {
        this.userList.removeIf(u -> u.getSsn().equals(ssn));
    }

    public void registryInAFile(String fileName) throws IOException {
        var writer = new FileWriter(fileName);
        writer.write(this.userList.toString());
        writer.close();
    }
}

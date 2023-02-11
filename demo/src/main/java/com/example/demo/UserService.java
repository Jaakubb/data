package com.example.demo;

import org.springframework.stereotype.Service;

import java.net.UnknownServiceException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    List<User> users = new ArrayList<>();

    public void addUser(User user) throws UserExsistException {

        Optional<User> first = users.stream()
                .filter ( userFromUserList -> userFromUserList.getUsername().equals(user.getUsername()))
                .findFirst();

        if(first.isPresent()){
            throw new UserExsistException();
        }

        users.add(user);


    }
}

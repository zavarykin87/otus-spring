package com.zavarykin.task3.service;

import com.zavarykin.task3.domain.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public User create(String firstName, String lastName) {
        return new User(firstName, lastName);
    }

}

package com.zavarykin.service;

import com.zavarykin.domain.User;

public class UserService {

    public User create(String firstName, String lastName) {
        return new User(firstName, lastName);
    }

}

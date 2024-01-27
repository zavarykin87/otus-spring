package com.zavarykin.service;

import com.zavarykin.domain.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    private final UserService userService = new UserService();

    @Test
    public void createUserTest() {
        User user = new User("Андрей", "Петров");
        assertEquals(user, userService.create("Андрей", "Петров"));
    }


}
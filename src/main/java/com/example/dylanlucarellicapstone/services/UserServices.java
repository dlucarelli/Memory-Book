package com.example.dylanlucarellicapstone.services;

import com.example.dylanlucarellicapstone.model.User;

import java.util.List;

public interface UserServices {
    List<User>getAllUsers();

    void saveUser(User user);

    User getUserById(long id);

    void deleteUserById(long id);
}

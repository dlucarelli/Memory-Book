package com.example.dylanlucarellicapstone.security;

import com.example.dylanlucarellicapstone.models.Child;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User findByEmail(String email);
    User save(UserRegistrationDto registration);

    User saveUser(User user);

    Child getChildById(User user, long id);

    void deleteChild(User user, Child child);
}


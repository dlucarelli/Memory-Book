package com.example.dylanlucarellicapstone.services;

import com.example.dylanlucarellicapstone.model.User;
import com.example.dylanlucarellicapstone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServicesImpl implements UserServices{

    private UserRepository userRepository;

    @Autowired
    public UserServicesImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void saveUser(User user) {
        this.userRepository.save(user);
    }

    @Override
    public User getUserById(long id) {
        Optional<User> optional = userRepository.findById(id);
        User user = null;
        if (optional.isPresent()) {
            user = optional.get();
        } else {
            throw new UserNotFoundException();
        }
        return user;
    }

    @Override
    public void deleteUserById(long id) {

        this.userRepository.deleteById(id);
    }
}

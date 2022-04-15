package com.example.dylanlucarellicapstone.repository;

import com.example.dylanlucarellicapstone.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserById(long id);
}

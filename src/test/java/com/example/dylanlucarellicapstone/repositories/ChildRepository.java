package com.example.dylanlucarellicapstone.repositories;

import com.example.dylanlucarellicapstone.models.Child;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChildRepository extends JpaRepository<Child, Long> {

    Child findFirstByName(String name);

}

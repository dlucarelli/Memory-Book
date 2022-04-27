package com.example.dylanlucarellicapstone.repositories;

import com.example.dylanlucarellicapstone.models.Memory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface MemoryRepository extends JpaRepository<Memory, Long> {
    Memory findByTitle(String title);

    Memory findByDate(Date date);
}

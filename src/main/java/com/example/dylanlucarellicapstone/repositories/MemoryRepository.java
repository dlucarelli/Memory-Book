package com.example.dylanlucarellicapstone.repositories;

import com.example.dylanlucarellicapstone.models.Memory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemoryRepository extends JpaRepository<Memory, Long> {
    Memory findByTitle(String title);
}

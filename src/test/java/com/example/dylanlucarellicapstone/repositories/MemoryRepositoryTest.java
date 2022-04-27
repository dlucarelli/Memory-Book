package com.example.dylanlucarellicapstone.repositories;

import com.example.dylanlucarellicapstone.models.Memory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class MemoryRepositoryTest {

    @Autowired
    private MemoryRepository memoryRepository;

//    @Test
//    void findByTitle_should_return_Memory_given_valid_title() {
//
//        Memory testMemory = memoryRepository.findByTitle("thing");
//        Assertions.assertThat(testMemory.getTitle()).isEqualTo("thing");
//    }

}

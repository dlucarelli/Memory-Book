package com.example.dylanlucarellicapstone.repositories;

import com.example.dylanlucarellicapstone.models.Child;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ChildRepositoryTest {

    @Autowired
    private ChildRepository childRepository;

    @Test
    void findFirstByName_should_return_Child_given_valid_name() {

        Child testChild = childRepository.findFirstByName("egg");
        Assertions.assertThat(testChild.getName()).isEqualTo("egg");
    }
}

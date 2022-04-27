package com.example.dylanlucarellicapstone.service;

import com.example.dylanlucarellicapstone.models.Child;

import com.example.dylanlucarellicapstone.models.Memory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ChildServiceImplTest {

    @Autowired
    private ChildService childService;

    @Test
    void getAllChildren() {

        List<Child> allChildren = childService.getAllChildren();
        int originalSize = allChildren.size();

        Child child = new Child();
        child.setName("Test");
        child.setAge(1L);
        childService.saveChild(child);
        int testedSize = childService.getAllChildren().size();

        Assertions.assertThat(testedSize).isEqualTo(originalSize + 1);
        Assertions.assertThat(allChildren.contains(child));
    }

    @Test
    void saveChild_should_add_child_to_database() {
        Child testChild = new Child();
        testChild.setName("Test");
        testChild.setAge(1L);
        childService.saveChild(testChild);
        Assertions.assertThat(childService.getAllChildren().contains(testChild));
    }

//    @Test
//    void getChildById_should_return_child_given_valid_id() {
//        List<Child> allChildren = childService.getAllChildren();
//        Child testChild = allChildren.get(0);
//        if (testChild != null) {
//            Child testChildById = childService.getChildById(testChild.getId());
//            Assertions.assertThat(testChildById).isEqualTo(testChild);
//        }
//    }


    @Test
    void getChildByName_should_return_child_given_valid_name() {
        Child testChild = childService.getChildByName("egg");
        Assertions.assertThat(testChild.getName()).isEqualTo("egg");
    }



//    @Test
//    void deleteChildById_should_delete_child_given_valid_id() {
//        List<Child> allChildren = childService.getAllChildren();
//        Child testChild = allChildren.get(0);
//        if (testChild != null) {
//            childService.deleteChildById(testChild.getId());
//            Assertions.assertThat(childService.getAllChildren().contains(testChild)).isEqualTo(false);
//        }
//
//    }
}

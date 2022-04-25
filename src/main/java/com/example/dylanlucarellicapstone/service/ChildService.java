package com.example.dylanlucarellicapstone.service;

import com.example.dylanlucarellicapstone.models.Child;
import com.example.dylanlucarellicapstone.models.Memory;

import java.util.List;

public interface ChildService {
    List<Child> getAllChildren();

    void saveChild(Child child);

    Child getChildById(long id);

    Child getChildByName(String name);

    void deleteMemory(Child child, Memory memory);

    void deleteChildById(long id);
}

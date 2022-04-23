package com.example.dylanlucarellicapstone.service;

import com.example.dylanlucarellicapstone.models.Child;

import java.util.List;

public interface ChildService {
    List<Child> getAllChildren();

    void saveChild(Child child);

    Child getChildById(long id);

    Child getChildByName(String name);

    void deleteChildById(long id);
}

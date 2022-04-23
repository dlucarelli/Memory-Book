package com.example.dylanlucarellicapstone.service;

import com.example.dylanlucarellicapstone.models.Child;
import com.example.dylanlucarellicapstone.repositories.ChildRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChildServiceImpl implements ChildService{

    private ChildRepository childRepository;

    @Autowired
    public ChildServiceImpl(ChildRepository childRepository) {
        this.childRepository = childRepository;
    }

    @Override
    public List<Child> getAllChildren() {
        return childRepository.findAll();
    }

    @Override
    public void saveChild(Child child) {
        childRepository.save(child);
    }

    @Override
    public Child getChildById(long id) {
        Optional<Child> child = childRepository.findById(id);
        if (child.isPresent()) {
            Child child1 = child.get();
            return child1;
        }
        throw new ChildNotFoundException();
    }

    @Override
    public Child getChildByName(String name) {
        Child child = childRepository.findFirstByName(name);
        if (child == null) {
            throw new ChildNotFoundException();
        }
        return child;
    }

    @Override
    public void deleteChildById(long id) {
        childRepository.deleteById(id);
    }
}

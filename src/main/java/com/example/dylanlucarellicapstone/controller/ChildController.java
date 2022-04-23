package com.example.dylanlucarellicapstone.controller;

import com.example.dylanlucarellicapstone.service.ChildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ChildController {

    private ChildService childService;

    public ChildController() {
    }

    @Autowired
    public ChildController(ChildService childService) {
        this.childService = childService;
    }

}

package com.example.dylanlucarellicapstone.controller;

import com.example.dylanlucarellicapstone.service.ChildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChildController {

    private ChildService childService;

    public ChildController() {
    }

    @Autowired
    public ChildController(ChildService childService) {
        this.childService = childService;
    }

    @GetMapping("/children")
    public String getAllChildren(Model model) {
        model.addAttribute("listChildren", childService.getAllChildren());
        return "children";
    }


}

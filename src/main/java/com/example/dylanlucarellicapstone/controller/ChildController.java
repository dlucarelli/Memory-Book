package com.example.dylanlucarellicapstone.controller;

import com.example.dylanlucarellicapstone.models.Child;
import com.example.dylanlucarellicapstone.service.ChildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

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

    @GetMapping("/showNewChildForm")
    public String showNewChildForm(Model model) {
        Child child = new Child();
        model.addAttribute("child", child);
        return "new_child";
    }

    @PostMapping("/saveChild")
    public String saveChild(@ModelAttribute("employee") @Valid Child child,
                               BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "new_child";
        }

        // save employee to database
        childService.saveChild(child);
        return "redirect:/";
    }

    @GetMapping("/showChildUpdate/{id}")
    public String showChildUpdate(@PathVariable(value = "id") long id, Model model) {

        Child child = childService.getChildById(id);

        model.addAttribute("child", child);
        return "update_child";
    }

    @GetMapping("/deleteChild/{id}")
    public String deleteChild(@PathVariable(value = "id") long id) {

        // call delete employee method
        this.childService.deleteChildById(id);
        return "redirect:/";
    }
}

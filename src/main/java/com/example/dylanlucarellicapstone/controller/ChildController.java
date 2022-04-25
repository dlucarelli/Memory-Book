package com.example.dylanlucarellicapstone.controller;

import com.example.dylanlucarellicapstone.models.Child;
import com.example.dylanlucarellicapstone.security.User;
import com.example.dylanlucarellicapstone.security.UserService;
import com.example.dylanlucarellicapstone.service.ChildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.security.Principal;

@Controller
public class ChildController {

    private UserService userService;
    private ChildService childService;

    public ChildController() {
    }

    @Autowired
    public ChildController(UserService userService, ChildService childService) {
        this.userService = userService;
        this.childService = childService;
    }

    @GetMapping("/children")
    public String getAllChildren(Principal principal, Model model) {
        User user = userService.findByEmail(principal.getName());
        model.addAttribute("listChildren", childService.getAllChildren());
        return "children";
    }

    @GetMapping("/showNewChildForm")
    public String showNewChildForm(@AuthenticationPrincipal Model model) {
        Child child = new Child();
        model.addAttribute("child", child);
        return "new_child";
    }

    @PostMapping("/saveChild")
    public String saveChild(@ModelAttribute("child") @Valid Child child,
                               BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "new_child";
        }

        // save employee to database
        childService.saveChild(child);
        return "redirect:/children";
    }

    @GetMapping("/showChildUpdate/{id}")
    public String showChildUpdate(@PathVariable(value = "id") long id, Model model) {

        Child child = childService.getChildById(id);

        model.addAttribute("child", child);
        return "update_child";
    }

    @GetMapping("/deleteChild/{id}")
    public String deleteChild(@PathVariable(value = "id") long id) {


        this.childService.deleteChildById(id);
        return "redirect:/";
    }
}

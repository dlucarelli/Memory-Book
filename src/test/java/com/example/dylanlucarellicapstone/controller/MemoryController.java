package com.example.dylanlucarellicapstone.controller;

import com.example.dylanlucarellicapstone.models.Child;
import com.example.dylanlucarellicapstone.models.Memory;
import com.example.dylanlucarellicapstone.security.User;
import com.example.dylanlucarellicapstone.security.UserService;
import com.example.dylanlucarellicapstone.service.ChildService;
import com.example.dylanlucarellicapstone.service.MemoryService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class MemoryController {

    private UserService userService;
    private ChildService childService;
    private MemoryService memoryService;

    public MemoryController() {
    }

    @Autowired
    public MemoryController(UserService userService, ChildService childService, MemoryService memoryService) {
        this.userService = userService;
        this.childService = childService;
        this.memoryService = memoryService;
    }

    @GetMapping("/memories/{id}")
    public String getAllMemories(@PathVariable(value = "id") long id, Principal principal, Model model) {
        User user = userService.findByEmail(principal.getName());
        Child child = userService.getChildById(user, id);
        model.addAttribute("listMemories", child.getMemory());
        model.addAttribute("childId", id);
        return "memories";
    }

    @GetMapping("/showNewMemoryForm/{id}")
    public String showNewMemoryForm(@PathVariable(value = "id") long id, Model model) {
        Memory memory = new Memory();
        model.addAttribute("memory", memory);
        model.addAttribute("id", id);
        return "new_memory";
    }

    @PostMapping("/saveMemory/{id}")
    public String saveMemory(@ModelAttribute("memory") @Valid Memory memory, Principal principal, @PathVariable(value = "id") long id,
                             BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "new_memory";
        }
        User user = userService.findByEmail(principal.getName());
        Child child = userService.getChildById(user, id);

        child.getMemory().add(memory);

//        memoryService.saveMemory(memory);
        childService.saveChild(child);
        return "redirect:/memories/{id}";
    }

    @PostMapping("/saveUpdateMemory/{childId}")
    public String saveUpdateMemory(@ModelAttribute("memory") @Valid Memory memory, @PathVariable(value = "childId") long id,
                                   BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "new_memory";
        }



        memoryService.saveMemory(memory);
        return "redirect:/memories/{childId}";
    }

    @GetMapping("/showMemoryUpdate/{childId}/{id}")
    public String showMemoryUpdate(@PathVariable(value = "childId") long childId, @PathVariable(value = "id") long id, Model model) {

        Memory memory = memoryService.getMemoryById(id);

        model.addAttribute("memory", memory);
        model.addAttribute("childId", childId);
        return "update_memory";
    }

//    @GetMapping("/memories/{date}")
//    public String showMemoryByDate(@PathVariable String date, Model model) {
//        Memory memoryByDate = memoryService.getMemoryByDate(date);
//
//        model.addAttribute("memoryByDate", memoryByDate);
//        return "memories";
//    }

    @GetMapping("/deleteMemory/{childId}/{id}")
    public String deleteMemory(@PathVariable(value = "childId") long childId, @PathVariable(value = "id") long id) {

        Child childById = childService.getChildById(childId);
        Memory memory = memoryService.getMemoryById(id);
        childService.deleteMemory(childById, memory);

        this.memoryService.deleteMemoryById(id);
        return "redirect:/memories/{childId}";
    }
}

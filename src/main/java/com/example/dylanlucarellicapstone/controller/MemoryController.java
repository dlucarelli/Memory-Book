package com.example.dylanlucarellicapstone.controller;

import com.example.dylanlucarellicapstone.models.Memory;
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

@Controller
public class MemoryController {

    private MemoryService memoryService;

    public MemoryController() {
    }

    @Autowired
    public MemoryController(MemoryService memoryService) {
        this.memoryService = memoryService;
    }

    @GetMapping("/memories")
    public String getAllMemories(Model model) {
        model.addAttribute("listMemories", memoryService.getAllMemories());
        return "memories";
    }

    @GetMapping("/showNewMemoryForm")
    public String showNewMemoryForm(Model model) {
        Memory memory = new Memory();
        model.addAttribute("memory", memory);
        return "new_memory";
    }

    @PostMapping("/saveMemory")
    public String saveMemory(@ModelAttribute("employee") @Valid Memory memory,
                            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "new_memory";
        }

        // save employee to database
        memoryService.saveMemory(memory);
        return "redirect:/";
    }

    @GetMapping("/showMemoryUpdate/{id}")
    public String showMemoryUpdate(@PathVariable(value = "id") long id, Model model) {

        Memory memory = memoryService.getMemoryById(id);

        model.addAttribute("memory", memory);
        return "update_memory";
    }

    @GetMapping("/deleteMemory/{id}")
    public String deleteMemory(@PathVariable(value = "id") long id) {


        this.memoryService.deleteMemoryById(id);
        return "redirect:/";
    }
}

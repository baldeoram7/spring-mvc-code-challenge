package com.api.controller;

import com.api.model.request.Pet;
import com.api.service.PetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class NavigationController {



    @Autowired
    private PetsService petsService;

    @GetMapping("/")
    String getPets(@RequestParam Optional<String> petsType) {
        return petsType.isPresent() ? "redirect:/listmissingpets?petsType=" + petsType.get() : "redirect:/listmissingpets";
    }

    @GetMapping("/loginsuccess")
    String loginSuccess(@RequestParam Optional<String> petsType) {
        return "redirect:/createpet";
    }

    @GetMapping("/createpet")
    String createPets(@ModelAttribute Pet createpet, Model model) {
        model.addAttribute("createpet", createpet);
        return "createpets";
    }
}

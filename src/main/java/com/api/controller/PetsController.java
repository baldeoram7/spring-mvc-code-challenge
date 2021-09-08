package com.api.controller;

import com.api.model.request.Pet;
import com.api.service.PetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class PetsController {

    @Autowired
    private PetsService petsService;

    @GetMapping("/listmissingpets")
    ModelAndView getPets(@RequestParam Optional<String> petsType) {
        List<Pet> sortedList = petsService.getPets(petsType);
        sortedList = sortedList.stream()
                .sorted(Comparator.comparing(Pet::getMissingSince).reversed())
                .collect(Collectors.toList());
        ModelAndView mv = new ModelAndView();
        mv.addObject("petsList", sortedList);
        mv.setViewName("listmissingpets.html");
        return mv;
    }

    @PostMapping("/createpets")
    String createPets(@Valid @ModelAttribute("createpet") Pet createpet, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "createpets";
        }
        petsService.savePets(createpet, null);
        return "redirect:/listmissingpets";
    }

}

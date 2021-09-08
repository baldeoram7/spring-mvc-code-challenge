package com.api.controller;

import com.api.service.PetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsersController {

    @Autowired
    private PetsService petsService;

    @GetMapping("/login")
    String getPets() {
        return "login";
    }

    @GetMapping("/users/login")
    String getHello() {
        return "listmissingpets";
    }
}
